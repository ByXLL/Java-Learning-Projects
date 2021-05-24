package com.brodog.mall.admin.dto.goods;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品规格 新增 dto
 * @author By-Lin
 */
@Data
public class GoodsSpecAddDto {
    @ApiModelProperty(value = "商品规格名称")
    @NotEmpty(message = "商品规格名称为空")
    private String name;

    @ApiModelProperty(value = "商品-属性分类 id")
    @NotNull(message = "商品-属性分类 id为空")
    private Long goodsAttrCateId;

    @ApiModelProperty(value = "可选值列表")
    private String valueList;

    @ApiModelProperty(value = "排序")
    private Integer sort;

}
