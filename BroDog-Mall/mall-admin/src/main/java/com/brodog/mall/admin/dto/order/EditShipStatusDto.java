package com.brodog.mall.admin.dto.order;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 发货信息 dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditShipStatusDto {
    @ApiModelProperty(value = "订单编号")
    @NotNull(message = "订单编号为空")
    private Long orderNumber;

    @ApiModelProperty(value = "快递公司")
    @NotNull(message = "订单编号为空")
    private String deliveryCompany;

    @ApiModelProperty(value = "物流单号")
    @NotNull(message = "订单编号为空")
    private String deliverySn;
}
