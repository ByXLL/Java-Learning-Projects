package com.brodog.mall.app.form.order;

import com.brodog.mall.common.entity.PagerParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 订单查询参数 表单
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderSelectParam extends PagerParam {
    @ApiModelProperty(value = "订单子状态：0->订单关闭；1->待发货；2->已发货；3->已完成；4->售后中；5->售后完成")
    private Integer status;
}
