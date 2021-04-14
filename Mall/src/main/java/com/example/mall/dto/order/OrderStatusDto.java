package com.example.mall.dto.order;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 订单状态 dto
 * @author By-Lin
 */
@Data
public class OrderStatusDto {
    @ApiParam(required = true)
    private String orderNumber;

    @ApiParam(required = true)
    private Integer status;
}
