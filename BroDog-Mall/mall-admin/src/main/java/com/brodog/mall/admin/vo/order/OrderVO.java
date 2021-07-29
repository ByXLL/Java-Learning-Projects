package com.brodog.mall.admin.vo.order;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 订单表  视图模型
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    @ApiModelProperty(value = "订单表 id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "订单编号")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderNumber;

    @ApiModelProperty(value = "订单主状态：0->已取消；1->进行中；2->已完成；")
    private Integer status;

    @ApiModelProperty(value = "订单子状态：0->订单关闭；1->待发货；2->已发货；3->已完成；4->售后中；5->售后完成")
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
    @JsonSerialize(using = ToStringSerializer.class)
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
    private Timestamp paymentTime;

    @ApiModelProperty(value = "发货时间")
    private Timestamp deliveryTime;

    @ApiModelProperty(value = "确认收货时间")
    private Timestamp receiveTime;

    @ApiModelProperty(value = "自动确认时间（天）")
    private Integer autoConfirmDay;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
}
