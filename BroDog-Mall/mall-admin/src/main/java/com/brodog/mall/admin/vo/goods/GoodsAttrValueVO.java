package com.brodog.mall.admin.vo.goods;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品属性值 vo
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsAttrValueVO {
    @ApiModelProperty(value = "商品-属性-属性值-id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "属性值名称")
    private String name;

    @ApiModelProperty(value = "商品-属性 id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long goodsAttrId;

    @ApiModelProperty(value = "商品-属性 属性名")
    private String goodsAttrName;

    @ApiModelProperty(value = "可选值列表，逗号拼接")
    private String valueList;

    @ApiModelProperty(value = "属性值录入方式，0 手动，1 列表选择")
    private Integer inputType;

    @ApiModelProperty(value = "排序")
    private Integer sort;
}
