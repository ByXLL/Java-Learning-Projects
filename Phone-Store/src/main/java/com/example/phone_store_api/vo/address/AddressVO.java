package com.example.phone_store_api.vo.address;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * 地址 vo
 * @author By-Lin
 */
@Data
@AllArgsConstructor
public class AddressVO {
    private Integer id;
    private String areaCode;
    private String name;
    private String tel;
    private String address;
}
