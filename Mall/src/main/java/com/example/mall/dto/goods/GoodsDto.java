package com.example.mall.dto.goods;

import lombok.Data;

import java.util.Date;

/**
 * 商品实体
 * @author By-Lin
 */
@Data
public class GoodsDto {
    private int goodsId;
    private String goodsName;
    private double goodsPrice;
    private int goodsStatus;
    private int storeCateId;
    private int goodsCount;
    private int isDel;
}
