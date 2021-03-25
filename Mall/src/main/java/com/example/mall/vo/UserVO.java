package com.example.mall.vo;

import lombok.Data;

import java.util.Date;

/**
 * 用户 vo
 * @author By-Lin
 */
@Data
public class UserVO {
    private int id;
    private String avatar;
    private String userName;
    private String phone;
    private double balance;
    private int status;
    private Date registTime;
}
