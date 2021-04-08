package com.example.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户地址 vo
 * @author By-Lin
 */
@Data
public class UserAddressVO {
    private Integer id;
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
