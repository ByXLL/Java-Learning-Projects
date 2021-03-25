package com.example.mall.vo;

import lombok.Data;

import java.util.Date;

/**
 * 商品实体
 * @author By-Lin
 */
@Data
public class GoodsVO {
    private int goodsId;
    private String goodsName;
    private int goodsPrice;
    private int goodsStatus;
    private int storeCateId;
    private int goodsCount;
    private Date createTime;
}
