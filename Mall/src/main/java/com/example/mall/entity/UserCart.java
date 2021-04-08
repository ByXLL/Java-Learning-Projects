package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品实体
 * @author By-Lin
 */
@Data
public class UserCart {
    private Integer id;
    private Integer goodsId;
    private Integer goodsCount;
    private Integer userId;
}
