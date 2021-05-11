package com.brodog.mall.admin.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品 分类 修改 dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCateEditDto {
    @ApiModelProperty(value = "商品分类id")
    @NotNull(message = "商品分类id 为空")
    private Long id;

    @ApiModelProperty(value = "上级分类")
    private Long pid;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "商品个数")
    private Integer count;

    @ApiModelProperty(value = "分类等级，1 一级，2 二级")
    private Integer level;

    @ApiModelProperty(value = "数量单位")
    private String unit;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "关键词")
    private String keyword;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "是否显示，0 否，1 是")
    private Integer isShow;

    @ApiModelProperty(value = "是否导航栏显示，0 否，1 是")
    private Integer isMenu;

    @ApiModelProperty(value = "是否删除，0 否，1 是")
    private Integer isDel;
}
