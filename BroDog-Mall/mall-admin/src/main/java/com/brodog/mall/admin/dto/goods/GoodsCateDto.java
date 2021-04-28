package com.brodog.mall.admin.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品 分类 dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCateDto {
    @ApiModelProperty(value = "商品分类id")
    private Long id;

    @ApiModelProperty(value = "上级分类")
    private Long pid;

    @ApiModelProperty(value = "分类名称")
    @NotEmpty(message = "分类名称为空")
    private String name;

    @ApiModelProperty(value = "商品个数")
    @NotNull(message = "商品个数为空")
    private Integer count;

    @ApiModelProperty(value = "分类等级，1 一级，2 二级")
    private Integer level;

    @ApiModelProperty(value = "数量单位")
    @NotEmpty(message = "数量单位为空")
    private String unit;

    @ApiModelProperty(value = "图标")
    @NotEmpty(message = "图标为空")
    private String icon;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "关键词")
    @NotEmpty(message = "关键词为空")
    private String keyword;

    @ApiModelProperty(value = "描述")
    @NotEmpty(message = "描述为空")
    private String description;

    @ApiModelProperty(value = "是否显示，0 否，1 是")
    private Integer isShow;

    @ApiModelProperty(value = "是否导航栏显示，0 否，1 是")
    private Integer isMenu;

    @ApiModelProperty(value = "是否删除，0 否，1 是")
    private Integer isDel;
}
