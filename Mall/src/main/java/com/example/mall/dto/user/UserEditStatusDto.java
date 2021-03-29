package com.example.mall.dto.user;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 用户添加 dto
 * @author By-Lin
 */
@Data
public class UserEditStatusDto {
    @ApiParam(required = true)
    private Integer id;

    @ApiParam(required = true)
    private Integer status;
}
