package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品实体
 * @author By-Lin
 */
@Data
public class UserAddress {
    private int id;
    private String address;
    private String province;
    private String city;
    private String area;
    private String consignee;
    private String phone;
    private String zipCode;
    private int isDefault;
    private Date createTime;
}
