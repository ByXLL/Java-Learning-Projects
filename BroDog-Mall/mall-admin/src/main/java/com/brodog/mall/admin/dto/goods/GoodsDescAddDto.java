package com.brodog.mall.admin.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品详情 新增 dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDescAddDto {

    @ApiModelProperty(value = "副标题")
    @NotEmpty(message = "副标题 为空")
    private String subtitle;

    @ApiModelProperty(value = "积分")
    private Double integral;

    @ApiModelProperty(value = "成长值")
    private Double growthValue;

    @ApiModelProperty(value = "详细页标题")
    @NotEmpty(message = "详细页标题 为空")
    private String descTitle;

    @ApiModelProperty(value = "详情")
    @NotEmpty(message = "详情 为空")
    private String desc;

    @ApiModelProperty(value = "关键字")
    @NotEmpty(message = "关键字 为空")
    private String keyword;

    @ApiModelProperty(value = "备注")
    private String remarks;
}
