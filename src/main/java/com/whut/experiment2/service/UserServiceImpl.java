package com.whut.experiment2.service;

import com.whut.experiment2.mapper.UserMapper;
import com.whut.experiment2.model.User;
import com.whut.experiment2.service.UserService;
import com.whut.experiment2.exception.ValidationException;
import com.whut.experiment2.exception.UserNotFoundException;
import com.whut.experiment2.exception.DuplicateUsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User register(User user) {
        // 检查用户名是否已存在
        User existingUser = userMapper.findByName(user.getName());
        if (existingUser != null) {
            throw new DuplicateUsernameException();
        }

        // 对密码进行MD5加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));

        // 插入用户数据
        userMapper.insert(user);
        return user;
    }

    @Override
    public boolean login(String name, String password) {
        User user = userMapper.findByName(name);
        if (user == null) {
            throw new UserNotFoundException();
        }

        // 验证密码
        String encryptedPassword = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!user.getPassword().equals(encryptedPassword)) {
            throw new ValidationException("密码错误");
        }

        return true;
    }

    @Override
    public boolean changePassword(String name, String oldPassword, String newPassword) {
        // 加密旧密码和新密码
        String encryptedOldPassword = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        String encryptedNewPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());

        Integer userId=getUserByName(name).getId();
        int affectedRows = userMapper.updatePassword(userId, encryptedOldPassword, encryptedNewPassword);
        return affectedRows > 0;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public User getUserByName(String name){return userMapper.findByName(name);}
}
