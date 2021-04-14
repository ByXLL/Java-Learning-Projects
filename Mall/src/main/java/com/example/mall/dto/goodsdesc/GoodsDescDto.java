package com.example.mall.dto.goodsdesc;

import io.swagger.annotations.ApiParam;
import lombok.Data;


/**
 * 商品详情 dto
 * @author By-Lin
 */
@Data
public class GoodsDescDto {
    @ApiParam(required = true)
    private Integer goodsId;

    @ApiParam(required = true)
    private String content;
}
