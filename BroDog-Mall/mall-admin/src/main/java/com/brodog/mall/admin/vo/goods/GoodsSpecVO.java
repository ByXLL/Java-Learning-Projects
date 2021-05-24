package com.brodog.mall.admin.vo.goods;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * 商品规格 dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSpecVO {
    @ApiModelProperty(value = "商品-规格-id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "商品规格名称")
    private String name;

    @ApiModelProperty(value = "商品-属性分类 id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long goodsAttrCateId;

//    @ApiModelProperty(value = "可选值列表")
//    private ArrayList<String> valueList;

    @ApiModelProperty(value = "商品-属性 属性名")
    private String goodsAttrName;

    @ApiModelProperty(value = "可选值列表")
    private String valueList;

    @ApiModelProperty(value = "排序")
    private Integer sort;

}
