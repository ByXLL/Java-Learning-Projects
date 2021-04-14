package com.example.mall.dto.user;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户编辑价格 dto
 * @author By-Lin
 */
@Data
public class UserEditBalanceDto {
    @ApiParam(required = true)
    private Integer id;

    @ApiParam(required = true)
    private BigDecimal balance;
}
