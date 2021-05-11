package com.brodog.mall.admin.dto.goods;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品规格 编辑 dto
 * @author By-Lin
 */
@Data
public class GoodsSpecEditDto {
    @ApiModelProperty(value = "商品-规格-id")
    @NotNull(message = "商品-规格-id 为空")
    private Long id;

    @ApiModelProperty(value = "商品规格名称")
    private String name;

    @ApiModelProperty(value = "商品-属性 id")
    @NotNull(message = "商品-属性 id为空")
    private Long goodsAttrId;

    @ApiModelProperty(value = "可选值列表")
    private String valueList;

    @ApiModelProperty(value = "排序")
    private Integer sort;

}
