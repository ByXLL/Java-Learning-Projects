package com.example.mall.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单商品实体
 * @author By-Lin
 */
@Data
public class OrderGoods {
    private Integer id;
    private Integer goodsId;
    private String orderNumber;
    private String goodsCateName;
    private String goodsName;
    private Integer goodsCount;
    private BigDecimal goodsPrice;
}
