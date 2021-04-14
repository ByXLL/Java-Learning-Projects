package com.example.mall.dto.useraddress;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 用户 地址添加 dto
 * @author By-Lin
 */
@Data
public class UserAddressAddDto {
    @ApiParam(required = true)
    private Integer userId;

    @ApiParam(required = true)
    private String address;

    @ApiParam(required = true)
    private String province;

    @ApiParam(required = true)
    private String city;

    @ApiParam(required = true)
    private String area;

    @ApiParam(required = true)
    private String consignee;

    @ApiParam(required = true)
    private String phone;

    @ApiParam(required = true)
    private String zipCode;

    @ApiParam(required = true)
    private Integer isDefault;
}
