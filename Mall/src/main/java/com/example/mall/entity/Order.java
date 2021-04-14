package com.example.mall.entity;

import lombok.Data;

import java.math.BigDecimal;
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
    private String consignee;
    private String userAddress;
    private String userPhone;
    private BigDecimal totalPrice;
    private Integer status;
    private Date payTime;
    private Date createTime;
}
