package com.example.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品 vo
 * @author By-Lin
 */
@Data
public class GoodsVO {
    private Integer goodsId;
    private String goodsName;
    private BigDecimal goodsPrice;
    private Integer goodsStatus;
    private Integer storeCateId;
    private Integer goodsCount;
    private Date createTime;
}
