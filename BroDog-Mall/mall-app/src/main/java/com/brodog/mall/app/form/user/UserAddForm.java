package com.brodog.mall.app.form.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * 用户新增表单数据
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddForm {
    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "用户名不能为空")
    private String name;

    @ApiModelProperty(value = "手机号码")
    @NotEmpty(message = "手机号码不能为空")
    private String phone;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;
}
