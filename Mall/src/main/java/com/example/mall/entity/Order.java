package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 订单实体
 * @author By-Lin
 */
@Data
public class Order {
    private int id;
    private String orderNumber;
    private int userId;
    private String userAddress;
    private int status;
    private Date payTime;
    private Date createTime;
}
