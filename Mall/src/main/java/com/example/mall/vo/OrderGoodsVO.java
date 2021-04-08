package com.example.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单商品 vo
 * @author By-Lin
 */
@Data
public class OrderGoodsVO {
    private Integer goodsId;
    private String orderNumber;
    private String goodsCateName;
    private String goodsName;
    private Integer goodsCount;
    private BigDecimal goodsPrice;
}
