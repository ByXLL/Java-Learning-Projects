package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品分类实体
 * @author By-Lin
 */
@Data
public class GoodsCate {
    private int cateId;
    private String cateName;
    private int isDel;
    private int catePid;
}
