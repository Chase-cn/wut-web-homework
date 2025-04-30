package com.whut.experiment2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

import java.io.File;
import java.io.IOException;

@RestController
public class ImageController {

    @Value("${image.storage.path}")
    private String storagePath;

    // 上传接口
    @PostMapping("/api/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "请选择文件";
        }

        // 创建存储目录（如果不存在）
        File dir = new File(storagePath);
        if (!dir.exists()) dir.mkdirs();

        // 生成唯一文件名
        String filename = UUID.randomUUID() + "." +
                file.getOriginalFilename().split("\\.")[1];

        // 保存文件
        file.transferTo(new File(dir, filename));

        return "http://localhost:8080/api/images/" + filename;
    }

    // 图片访问接口
    @GetMapping("/api/images/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        //System.out.println("图片被查询");  //控制台调试用,似乎不能热更新
        File file = new File(storagePath + '/' + filename);//亏麻了,少个/难了我好久
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG) // 自动识别图片类型
                .body(new FileSystemResource(file));
    }
}
