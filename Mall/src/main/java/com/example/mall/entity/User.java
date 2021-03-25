package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体
 * @author By-Lin
 */
@Data
public class User {
    private int id;
    private String avatar;
    private String userName;
    private String password;
    private String phone;
    private double balance;
    private int status;
    private Date registTime;
}
