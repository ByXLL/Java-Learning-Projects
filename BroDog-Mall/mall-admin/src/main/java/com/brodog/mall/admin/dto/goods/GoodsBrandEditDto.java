package com.brodog.mall.admin.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品品牌 编辑 dto
 * @author By-Lin
 */
@Data
public class GoodsBrandEditDto {
    @ApiModelProperty(value = "品牌id")
    @NotNull(message = "品牌id 为空")
    private Long id;

    @ApiModelProperty(value = "品牌名称")
    private String name;

    @ApiModelProperty(value = "品牌首字母")
    private String firstLetter;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "是否显示，0 否，1 是")
    private Integer isShow;

    @ApiModelProperty(value = "logo")
    private String logo;

    @ApiModelProperty(value = "品牌专区 图片")
    private String bigPic;

    @ApiModelProperty(value = "是否删除")
    private Integer isDel;
}
