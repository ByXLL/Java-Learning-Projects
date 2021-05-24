package com.brodog.mall.admin.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品属性值 添加dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsAttrValueAddDto {
    @ApiModelProperty(value = "商品id",required = true)
//    @NotNull(message = "商品id为空")
    private Long goodsId;

    @ApiModelProperty(value = "商品属性 id",required = true)
    @NotNull(message = "商品属性id 为空")
    private Long goodsAttrId;

    @ApiModelProperty(value = "属性值",required = true)
    private String value;
}
