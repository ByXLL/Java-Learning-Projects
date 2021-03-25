package com.example.mall.dto.user;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 用户修改 dto
 * @author By-Lin
 */
@Data
public class UserEditPassWordDto {
    @ApiParam(required = true)
    private Integer id;

    @ApiParam(required = true)
    private String password;
}
