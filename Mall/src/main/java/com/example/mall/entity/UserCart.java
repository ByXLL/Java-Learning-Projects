package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品实体
 * @author By-Lin
 */
@Data
public class UserCart {
    private int id;
    private int goodsId;
    private int userId;
}
