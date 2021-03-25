package com.example.mall.dto.user;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 用户修改 dto
 * @author By-Lin
 */
@Data
public class UserEditDto {
    @ApiParam(required = true)
    private int id;

    private String avatar;
    private String userName;
    private String phone;

    @ApiParam(required = true)
    private double balance;

    @ApiParam(required = true)
    private int status;
}
