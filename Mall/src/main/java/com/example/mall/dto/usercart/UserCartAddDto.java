package com.example.mall.dto.usercart;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 购物车 添加 dto
 * @author By-Lin
 */
@Data
public class UserCartAddDto {
    @ApiParam(required = true)
    private Integer goodsId;

    @ApiParam(required = true)
    private Integer goodsCount;

    @ApiParam(required = true)
    private Integer userId;
}
