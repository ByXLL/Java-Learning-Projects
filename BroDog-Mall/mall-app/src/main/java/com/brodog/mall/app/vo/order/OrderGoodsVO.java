package com.brodog.mall.app.vo.order;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 订单商品表 vo
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderGoods对象", description="订单商品 vo")
public class OrderGoodsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "订单 id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderId;

    @ApiModelProperty(value = "订单编号")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderNumber;

    @ApiModelProperty(value = "商品id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long goodsId;

    @ApiModelProperty(value = "分类id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long goodsCateId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品分类id")
    private Long cateId;

    @ApiModelProperty(value = "商品个数")
    private Integer count;

    @ApiModelProperty(value = "品牌 id")
    private Long brandId;

    @ApiModelProperty(value = "商品图片")
    private String goodsPic;

    @ApiModelProperty(value = "销售价格")
    private BigDecimal sellPrice;

    @ApiModelProperty(value = "sku id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long skuId;

    @ApiModelProperty(value = "sku编号")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long skuNumber;

    @ApiModelProperty(value = "sku数据")
    private String skuData;

    @ApiModelProperty(value = "商品促销名称")
    private String promotionName;

    @ApiModelProperty(value = "促销减免金额")
    private BigDecimal promotionPrice;

    @ApiModelProperty(value = "优惠卷减免金额")
    private BigDecimal couponPrice;

    @ApiModelProperty(value = "最后需支付金额")
    private BigDecimal payPrice;


}
