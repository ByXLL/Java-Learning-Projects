package com.brodog.mall.admin.dto.goods;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品属性值 dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsAttrValueDto {
    @ApiModelProperty(value = "商品-属性-属性值-id")
    private Long id;

    @ApiModelProperty(value = "属性值名称")
    @NotEmpty(message = "商品规格名称为空")
    private String name;

    @ApiModelProperty(value = "商品-属性 id")
    @NotNull(message = "商品-属性 id 为空")
    private Long goodsAttrId;

    @ApiModelProperty(value = "可选值列表，逗号拼接")
    private String valueList;

    @ApiModelProperty(value = "属性值录入方式，0 手动，1 列表选择")
    private Integer inputType;

    @ApiModelProperty(value = "排序")
    private Integer sort;
}
