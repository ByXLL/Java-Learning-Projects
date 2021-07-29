package com.brodog.mall.app.form.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * 用户登录表单数据
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginForm {
    @ApiModelProperty(value = "手机号码")
    @NotEmpty(message = "手机号码不能为空")
    private String phone;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;
}
