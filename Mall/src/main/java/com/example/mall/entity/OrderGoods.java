package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 订单商品实体
 * @author By-Lin
 */
@Data
public class OrderGoods {
    private int id;
    private int goodsId;
    private int orderId;
    private String goodsCateName;
    private String goodsName;
    private int goodsCount;
    private double goodsPrice;

}
