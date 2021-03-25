package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品分类实体
 * @author By-Lin
 */
@Data
public class GoodsCate {
    private Integer cateId;
    private String cateName;
    private Integer isDel;
    private Integer catePid;
}
