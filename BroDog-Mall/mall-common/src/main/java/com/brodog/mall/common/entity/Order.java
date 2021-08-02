package com.brodog.mall.common.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.sql.Timestamp;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author By-Lin
 * @since 2021-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("`order`")
@ApiModel(value="Order对象", description="订单表")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单表 id")
    private Long id;

    @ApiModelProperty(value = "订单编号")
    private String orderNumber;

    @TableField(value="`status`")
    @ApiModelProperty(value = "订单主状态：0->已取消；1->进行中；2->已完成；")
    private Integer status;

    @ApiModelProperty(value = "订单子状态：0->订单关闭；1->待支付；2->待发货；3->已发货；4->已完成；5->售后中；6->售后完成；")
    private Integer subStatus;

    @ApiModelProperty(value = "订单是否已支付：0->否，1->是")
    private Integer payStatus;

    @ApiModelProperty(value = "订单来源：0->直接下单，1->购物车结算")
    private Integer sourceType;

    @ApiModelProperty(value = "订单类型：0->正常订单，1->秒杀订单")
    private Integer orderType;

    @ApiModelProperty(value = "支付方式：0->银行卡，1->账户余额，2->支付宝，3->微信")
    private Integer payType;

    @ApiModelProperty(value = "订单总金额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "订单支付金额")
    private BigDecimal payAmount;

    @ApiModelProperty(value = "运费金额")
    private BigDecimal freightAmount;

    @ApiModelProperty(value = "积分优惠金额")
    private BigDecimal integrationAmount;

    @ApiModelProperty(value = "优惠券优惠金额")
    private BigDecimal couponAmount;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "收货人姓名")
    private String receiverName;

    @ApiModelProperty(value = "收货人电话")
    private String receiverPhone;

    @ApiModelProperty(value = "邮政编码")
    private String receiverPostCode;

    @ApiModelProperty(value = "省")
    private String receiverProvince;

    @ApiModelProperty(value = "市")
    private String receiverCity;

    @ApiModelProperty(value = "区")
    private String receiverRegion;

    @ApiModelProperty(value = "详细地址")
    private String receiverDetailAddress;

    @ApiModelProperty(value = "订单备注")
    private String remarks;

    @ApiModelProperty(value = "快递公司")
    private String deliveryCompany;

    @ApiModelProperty(value = "物流单号")
    private String deliverySn;

    @ApiModelProperty(value = "确认收货状态：0->未收货，1->已收货")
    private Integer confirmStatus;

    @ApiModelProperty(value = "支付时间")
    private Date paymentTime;

    @ApiModelProperty(value = "发货时间")
    private Date deliveryTime;

    @ApiModelProperty(value = "确认收货时间")
    private Date receiveTime;

    @ApiModelProperty(value = "自动确认收货时间（天）")
    private Integer autoConfirmDay;

    @ApiModelProperty(value = "是否删除，0 否，1 是")
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;


}
