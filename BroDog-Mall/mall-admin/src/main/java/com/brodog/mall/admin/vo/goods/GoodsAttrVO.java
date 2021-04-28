package com.brodog.mall.admin.vo.goods;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * 商品属性 vo
 * @author By-Lin
 */
@Data
@AllArgsConstructor
public class GoodsAttrVO {
    @ApiModelProperty(value = "商品-属性id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "属性名称")
    private String name;

    @ApiModelProperty(value = "属性个数")
    private Integer attrCount;

    @ApiModelProperty(value = "规格个数")
    private Integer specCount;
}
