package com.example.mall.dto.useraddress;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 用户 地址编辑 dto
 * @author By-Lin
 */
@Data
public class UserAddressEditDto {
    @ApiParam(required = true)
    private Integer id;

    @ApiParam(required = true)
    private Integer userId;

    private String address;
    private String province;
    private String city;
    private String area;
    private String consignee;
    private String phone;
    private String zipCode;
    private Integer isDefault;
}
