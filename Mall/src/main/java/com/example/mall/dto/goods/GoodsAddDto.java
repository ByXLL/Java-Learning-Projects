package com.example.mall.dto.goods;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 商品添加 dto
 * @author By-Lin
 */
@Data
public class GoodsAddDto {

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
