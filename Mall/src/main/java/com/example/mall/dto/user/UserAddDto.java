package com.example.mall.dto.user;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.util.Date;

/**
 * 用户添加 dto
 * @author By-Lin
 */
@Data
public class UserAddDto {
    private String avatar;

    @ApiParam(required = true)
    private String userName;

    @ApiParam(required = true)
    private String password;

    @ApiParam(required = true)
    private String phone;
}
