package com.brodog.mall.admin.form.order;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.brodog.mall.common.entity.PagerParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 订单查询 表单参数
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderSelectParam extends PagerParam {
    @ApiModelProperty(value = "订单编号")
    private Long orderNumber;

    @ApiModelProperty(value = "订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer status;

    @ApiModelProperty(value = "订单来源：0->直接下单，1->购物车结算")
    private Integer sourceType;

    @ApiModelProperty(value = "订单类型：0->正常订单，1->秒杀订单")
    private Integer orderType;

    @ApiModelProperty(value = "支付方式：0->银行卡，1->账户余额，2->支付宝，3->微信")
    private Integer payType;

    @ApiModelProperty(value = "收货人姓名")
    private String receiverName;

    @ApiModelProperty(value = "收货人电话")
    private String receiverPhone;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
