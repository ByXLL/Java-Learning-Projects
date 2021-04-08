package com.example.mall.dto.goods;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品编辑 dto
 * @author By-Lin
 */
@Data
public class GoodsEditDto {
    @ApiParam(required = true)
    private Integer goodsId;

    @ApiParam(required = true)
    private String goodsName;

    @ApiParam(required = true)
    private BigDecimal goodsPrice;

    @ApiParam(required = true)
    private Integer goodsStatus;

    @ApiParam(required = true)
    private Integer storeCateId;

    @ApiParam(required = true)
    private Integer goodsCount;

    @ApiParam(required = true)
    private String content;

    @ApiParam(required = true)
    private String mainPic;

    @ApiParam(required = true)
    private String subPics;
}
