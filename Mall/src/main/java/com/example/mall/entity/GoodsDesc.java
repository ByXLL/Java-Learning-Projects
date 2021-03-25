package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品详情实体
 * @author By-Lin
 */
@Data
public class GoodsDesc {
    private int descId;
    private String goodsName;
    private int goodsId;
    private int goodsStatus;
    private int storeCateId;
    private int goodsCount;
    private Date create_time;
}
