package com.brodog.mall.app.form.order;

import com.brodog.mall.app.dto.order.OrderAddDto;
import com.brodog.mall.app.dto.order.OrderGoodsAddDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 订单添加表单数据
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderAddForm extends OrderAddDto {

    @ApiModelProperty(value = "订单商品列表")
    @Size(min = 1, message = "订单商品为空")
    @NotNull(message = "订单商品为空")
    private List<OrderGoodsAddDto> orderGoodsList;
}
