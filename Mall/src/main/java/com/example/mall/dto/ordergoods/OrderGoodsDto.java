package com.example.mall.dto.ordergoods;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单商品 dto
 * @author By-Lin
 */
@Data
public class OrderGoodsDto {
    private Integer goodsId;
    private String goodsCateName;
    private String goodsName;
    private Integer goodsCount;
    private BigDecimal goodsPrice;
}
