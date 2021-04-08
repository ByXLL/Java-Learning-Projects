package com.example.mall.dto.order;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单 新增 dto
 * @author By-Lin
 */
@Data
public class OrderAddDto {
    @ApiParam(required = true)
    private Integer userId;

    @ApiParam(required = true)
    private String userPhone;

    @ApiParam(required = true)
    private String consignee;

    @ApiParam(required = true)
    private String userAddress;

    @ApiParam(required = true)
    private BigDecimal totalPrice;

    @ApiParam(required = true)
    private Integer goodsId;

    @ApiParam(required = true)
    private Integer goodsCount;

    @ApiParam(required = true)
    private String goodsCateName;

    @ApiParam(required = true)
    private String goodsName;

    @ApiParam(required = true)
    private BigDecimal goodsPrice;
}
