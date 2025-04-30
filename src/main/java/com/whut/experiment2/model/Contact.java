package com.whut.experiment2.model;

import lombok.Data;

import java.util.Date;

@Data
public class Contact {
    private Long id;        // 假设表中有id字段
    private String name;
    private String province;
    private String city;
    private String address;
    private String zip;
    private Date date;
}