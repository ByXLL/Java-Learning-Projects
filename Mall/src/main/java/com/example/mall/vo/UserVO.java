package com.example.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户 vo
 * @author By-Lin
 */
@Data
public class UserVO {
    private Integer id;
    private String avatar;
    private String userName;
    private String phone;
    private BigDecimal balance;
    private Integer status;
    private Date registTime;
}
