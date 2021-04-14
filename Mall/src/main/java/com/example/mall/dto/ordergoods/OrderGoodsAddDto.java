package com.example.mall.dto.ordergoods;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单商品添加 dto
 * @author By-Lin
 */
@Data
public class OrderGoodsAddDto {
    private Integer goodsId;
    private Integer orderId;
    private String goodsCateName;
    private String goodsName;
    private Integer goodsCount;
    private BigDecimal goodePrice;
}
