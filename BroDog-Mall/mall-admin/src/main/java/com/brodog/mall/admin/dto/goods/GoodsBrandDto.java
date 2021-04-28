package com.brodog.mall.admin.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 商品品牌 dto
 * @author By-Lin
 */
@Data
public class GoodsBrandDto {
    @ApiModelProperty(value = "品牌id")
    private Long id;

    @ApiModelProperty(value = "品牌名称")
    @NotEmpty(message = "品牌名称为空")
    private String name;

    @ApiModelProperty(value = "品牌首字母")
    private String firstLetter;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "是否显示，0 否，1 是")
    private Integer isShow;

    @ApiModelProperty(value = "logo")
    @NotEmpty(message = "logo为空")
    private String logo;

    @ApiModelProperty(value = "品牌专区 图片")
    @NotEmpty(message = "品牌专区图片为空")
    private String bigPic;

    @ApiModelProperty(value = "是否删除")
    private Integer isDel;
}
