package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 订单实体
 * @author By-Lin
 */
@Data
public class Order {
    private Integer id;
    private String orderNumber;
    private Integer userId;
    private String userAddress;
    private Integer status;
    private Date payTime;
    private Date createTime;
}
