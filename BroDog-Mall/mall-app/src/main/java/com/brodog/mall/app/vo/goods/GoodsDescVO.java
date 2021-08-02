package com.brodog.mall.app.vo.goods;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品描述 vo
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDescVO {
    @ApiModelProperty(value = "主键")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "副标题")
    private String subtitle;

    @ApiModelProperty(value = "积分")
    private Double integral;

    @ApiModelProperty(value = "成长值")
    private Double growthValue;

    @ApiModelProperty(value = "详细页标题")
    private String descTitle;

    @ApiModelProperty(value = "详情")
    private String desc;

    @ApiModelProperty(value = "关键字")
    private String keyword;

    @ApiModelProperty(value = "备注")
    private String remarks;
}
