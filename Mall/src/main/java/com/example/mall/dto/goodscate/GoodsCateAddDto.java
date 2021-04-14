package com.example.mall.dto.goodscate;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 商品分类 添加 dto
 * @author By-Lin
 */
@Data
public class GoodsCateAddDto {
    @ApiParam(required = true)
    private String cateName;

    private Integer catePid;
}
