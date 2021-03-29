package com.example.mall.dto.user;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 用户登录 dto
 * @author By-Lin
 */
@Data
public class UserLoginDto {
    @ApiParam(required = true)
    private String userName;

    @ApiParam(required = true)
    private String password;
}
