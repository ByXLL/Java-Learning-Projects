package com.example.mall.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户实体
 * @author By-Lin
 */
@Data
public class User {
    private Integer id;
    private String avatar;
    private String userName;
    private String password;
    private String phone;
    private BigDecimal balance;
    private Integer status;
    private Date registTime;
}
