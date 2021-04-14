package com.example.mall.dto.goodscate;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 商品分类 编辑 dto
 * @author By-Lin
 */
@Data
public class GoodsCateEditDto {
    @ApiParam(required = true)
    private Integer cateId;
    private String cateName;
    private Integer catePid;
}
