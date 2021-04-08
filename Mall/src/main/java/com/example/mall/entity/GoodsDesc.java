package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品详情实体
 * @author By-Lin
 */
@Data
public class GoodsDesc {
    private Integer descId;
    private Integer goodsId;
    private String content;
}
