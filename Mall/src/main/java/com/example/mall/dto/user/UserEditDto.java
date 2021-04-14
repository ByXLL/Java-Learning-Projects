package com.example.mall.dto.user;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户修改 dto
 * @author By-Lin
 */
@Data
public class UserEditDto {
    @ApiParam(required = true)
    private Integer id;

    private String avatar;
    private String userName;
    private String phone;

    @ApiParam(required = true)
    private BigDecimal balance;

    @ApiParam(required = true)
    private Integer status;
}
