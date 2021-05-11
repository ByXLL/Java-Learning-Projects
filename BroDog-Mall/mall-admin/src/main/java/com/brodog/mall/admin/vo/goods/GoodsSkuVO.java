package com.brodog.mall.admin.vo.goods;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 商品 sku vo
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSkuVO {
    @ApiModelProperty(value = "id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "商品id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long goodsId;

    @ApiModelProperty(value = "sku 编号")
    @JsonSerialize(using= ToStringSerializer.class)
    private Integer skuNumber;

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
