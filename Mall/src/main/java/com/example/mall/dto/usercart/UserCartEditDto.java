package com.example.mall.dto.usercart;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 购物车 编辑 dto
 * @author By-Lin
 */
@Data
public class UserCartEditDto {
    @ApiParam(required = true)
    private Integer id;

    @ApiParam(required = true)
    private Integer goodsCount;
}
