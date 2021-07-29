package com.brodog.mall.app.dto.order;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 订单新增dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderAddDto {
    @NotNull(message = "订单来源为空")
    @ApiModelProperty(value = "订单来源：0->直接下单，1->购物车结算")
    private Integer sourceType;

    @NotNull(message = "订单来源为空")
    @ApiModelProperty(value = "订单类型：0->正常订单，1->秒杀订单")
    private Integer orderType;

    @NotNull(message = "支付方式为空")
    @ApiModelProperty(value = "支付方式：0->银行卡，1->账户余额，2->支付宝，3->微信")
    private Integer payType;

//    @NotNull(message = "订单总金额为空")
//    @ApiModelProperty(value = "订单总金额")
//    private BigDecimal totalAmount;
//
//    @NotNull(message = "订单支付金额为空")
//    @ApiModelProperty(value = "订单支付金额")
//    private BigDecimal payAmount;

//    @ApiModelProperty(value = "运费金额")
//    private BigDecimal freightAmount;
//
//    @ApiModelProperty(value = "积分优惠金额")
//    private BigDecimal integrationAmount;

//    @ApiModelProperty(value = "优惠券优惠金额")
//    private BigDecimal couponAmount;

    @NotNull(message = "用户id为空")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @NotEmpty(message = "收货人姓名为空")
    @ApiModelProperty(value = "收货人姓名")
    private String receiverName;

    @NotEmpty(message = "收货人电话为空")
    @ApiModelProperty(value = "收货人电话")
    @Length(min = 11, max = 11, message = "收货人电话号码格式错误")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "收货人电话号码格式错误")
    private String receiverPhone;

    @ApiModelProperty(value = "邮政编码")
    private String receiverPostCode;

    @ApiModelProperty(value = "省")
    private String receiverProvince;

    @ApiModelProperty(value = "市")
    private String receiverCity;

    @ApiModelProperty(value = "区")
    private String receiverRegion;

    @NotEmpty(message = "详细地址为空")
    @ApiModelProperty(value = "详细地址")
    private String receiverDetailAddress;

}
