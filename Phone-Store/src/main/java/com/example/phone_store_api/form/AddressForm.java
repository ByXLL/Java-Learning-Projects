package com.example.phone_store_api.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 前端 地址信息 表单数据
 * @author By-Lin
 */
@Data
public class AddressForm {
    private Integer id;
    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "手机号码不能为空")
    private String tel;

    @NotEmpty(message = "省不能为空")
    private String province;

    @NotEmpty(message = "市不能为空")
    private String city;

    @NotEmpty(message = "区不能为空")
    private String county;

    @NotEmpty(message = "邮政编码不能为空")
    private String areaCode;

    @NotEmpty(message = "详细地址不能为空")
    private String addressDetail;
}
