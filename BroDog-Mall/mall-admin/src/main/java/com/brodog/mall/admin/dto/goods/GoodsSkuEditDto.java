package com.brodog.mall.admin.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 商品 sku 编辑 dto
 * @author By-Lin
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSkuEditDto {
    @ApiModelProperty(value = "id")
//    @NotNull( message = "sku id 为空")
    private Long id;

    @ApiModelProperty(value = "商品id")
    @NotNull(message = "商品id 为空")
    private Long goodsId;

    @ApiModelProperty(value = "sku 编号")
    private String skuNumber;

    @ApiModelProperty(value = "商品 单价")
    private BigDecimal price;

    @ApiModelProperty(value = "促销 价格")
    private BigDecimal promotionPrice;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "最低库存，报警量")
    private Integer lowStock;

    @ApiModelProperty(value = "商品图片")
    private String pic;

    @ApiModelProperty(value = "锁定库存")
    private Integer lockStock;

    @ApiModelProperty(value = "sku json数据")
    private String data;

}
