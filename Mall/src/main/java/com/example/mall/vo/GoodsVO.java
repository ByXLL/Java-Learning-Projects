package com.example.mall.vo;

import lombok.Data;

import java.util.Date;

/**
 * 商品实体
 * @author By-Lin
 */
@Data
public class GoodsVO {
    private Integer goodsId;
    private String goodsName;
    private Integer goodsPrice;
    private Integer goodsStatus;
    private Integer storeCateId;
    private Integer goodsCount;
    private Date createTime;
}
