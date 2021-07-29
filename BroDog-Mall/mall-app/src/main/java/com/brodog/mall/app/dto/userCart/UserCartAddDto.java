package com.brodog.mall.app.dto.userCart;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 购物车添加dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCartAddDto {
    @NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @NotEmpty(message = "商品名称不能为空")
    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @NotNull(message = "商品个数不能为空")
    @ApiModelProperty(value = "商品个数")
    private Integer count;

    @NotNull(message = "商品价格不能为空")
    @ApiModelProperty(value = "商品价格")
    private BigDecimal price;

    @NotEmpty(message = "商品名称不能为空")
    @ApiModelProperty(value = "sku数据")
    private String skuData;
}
