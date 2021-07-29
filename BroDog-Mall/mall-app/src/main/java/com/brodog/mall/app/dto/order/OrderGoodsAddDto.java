package com.brodog.mall.app.dto.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 订单商品 dto
 * @author By-Lin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderGoodsAddDto {
    @NotNull(message = "商品id为空")
    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @NotNull(message = "订单商品个数为空")
    @ApiModelProperty(value = "商品个数")
    private Integer count;

    @NotEmpty(message = "订单商品图片为空")
    @ApiModelProperty(value = "商品图片")
    private String goodsPic;

    @NotNull(message = "订单商品sku id为空")
    @ApiModelProperty(value = "sku id")
    private Long skuId;

    @NotNull(message = "订单商品sku编号 为空")
    @ApiModelProperty(value = "sku编号")
    private String skuNumber;

    @NotEmpty(message = "订单商品sku数据为空")
    @ApiModelProperty(value = "sku数据")
    private String skuData;

    @ApiModelProperty(value = "商品促销名称")
    private String promotionName;
}
