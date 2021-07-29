package com.brodog.mall.app.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 用户修改密码dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPasswordDto {
    @NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "用户id")
    private Long id;

    @NotEmpty(message = "旧密码不能为空")
    @ApiModelProperty(value = "旧密码")
    private String oldPassword;

    @NotEmpty(message = "新密码不能为空")
    @ApiModelProperty(value = "密码")
    private String newPassword;
}
