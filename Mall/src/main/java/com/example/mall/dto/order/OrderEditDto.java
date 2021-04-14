package com.example.mall.dto.order;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单编辑 dto
 * @author By-Lin
 */
@Data
public class OrderEditDto {
    @ApiParam(required = true)
    private String orderNumber;
    private String consignee;
    private String userAddress;
    private String userPhone;
}
