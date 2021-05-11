package com.brodog.mall.admin.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 商品 sku 新增 dto
 * @author By-Lin
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSkuAddDto {
    @ApiModelProperty(value = "商品id")
    @NotNull(message = "商品id 为空")
    private Long goodsId;

    @ApiModelProperty(value = "sku 编号")
    private Integer skuNumber;

    @ApiModelProperty(value = "商品 单价")
    @NotNull(message = "商品单价 为空")
    private BigDecimal price;

    @ApiModelProperty(value = "促销 价格")
    @NotNull(message = "促销价格 为空")
    private BigDecimal promotionPrice;

    @ApiModelProperty(value = "库存")
    @NotNull(message = "库存 为空")
    private Integer stock;

    @ApiModelProperty(value = "最低库存，报警量")
    @NotNull(message = "最低库存 为空")
    private Integer lowStock;

    @ApiModelProperty(value = "商品图片")
    @NotEmpty(message = "商品图片 为空")
    private String pic;

    @ApiModelProperty(value = "锁定库存")
    @NotNull(message = "锁定库存量 为空")
    private Integer lockStock;

    @ApiModelProperty(value = "sku json数据")
    private String data;

}
