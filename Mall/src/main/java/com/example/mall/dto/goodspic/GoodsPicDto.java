package com.example.mall.dto.goodspic;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 商品 主图/小图 dto
 * @author By-Lin
 */
@Data
public class GoodsPicDto {
    @ApiParam(required = true)
    private Integer goodsId;

    @ApiParam(required = true)
    private String url;
}
