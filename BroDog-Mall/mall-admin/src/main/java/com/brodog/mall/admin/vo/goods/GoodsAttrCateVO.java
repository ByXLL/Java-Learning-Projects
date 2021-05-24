package com.brodog.mall.admin.vo.goods;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 商品属性分类 vo
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsAttrCateVO {
    @ApiModelProperty(value = "商品-属性分类id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "属性分类名称")
    private String name;

    @ApiModelProperty(value = "属性值个数")
    private Integer attrCount;

    @ApiModelProperty(value = "规格个数")
    private Integer specCount;
}
