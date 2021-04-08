package com.example.mall.dto.goods;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品查询 dto
 * @author By-Lin
 */
@Data
public class GoodsSelectDto {
    private Integer goodsId;
    private String goodsName;
    private Integer goodsStatus;
    private Integer storeCateId;
}
