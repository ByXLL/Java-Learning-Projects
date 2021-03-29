package com.example.mall.dto.goods;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品实体
 * @author By-Lin
 */
@Data
public class GoodsDto {
    private Integer goodsId;
    private String goodsName;
    private BigDecimal goodsPrice;
    private Integer goodsStatus;
    private Integer storeCateId;
    private Integer goodsCount;
    private Integer isDel;
}
