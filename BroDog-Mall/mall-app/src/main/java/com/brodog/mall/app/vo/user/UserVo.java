package com.brodog.mall.app.vo.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 用户信息 vo
 * @author By-Lin
 */
public class UserVo {

    @ApiModelProperty(value = "用户id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "用户名")
    @JsonSerialize(using = ToStringSerializer.class)
    private String name;

    @ApiModelProperty(value = "手机号码")
    @JsonSerialize(using = ToStringSerializer.class)
    private String phone;

    @ApiModelProperty(value = "头像")
    @JsonSerialize(using = ToStringSerializer.class)
    private String avatar;

    @ApiModelProperty(value = "余额")
    @JsonSerialize(using = ToStringSerializer.class)
    private BigDecimal balance;

    @ApiModelProperty(value = "积分")
    @JsonSerialize(using = ToStringSerializer.class)
    private Double integral;

    @ApiModelProperty(value = "成长值")
    @JsonSerialize(using = ToStringSerializer.class)
    private Double growthValue;
}
