package com.brodog.mall.admin.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品属性分类 添加dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsAttrCateAddDto {
    @ApiModelProperty(value = "属性分类名称",required = true)
    @NotEmpty(message = "属性分类名称为空")
    private String name;

    @ApiModelProperty(value = "属性个数",required = true)
    @NotNull(message = "属性个数为空")
    private Integer attrCount;

    @ApiModelProperty(value = "规格个数",required = true)
    @NotNull(message = "规格个数为空")
    private Integer specCount;

    @ApiModelProperty(value = "是否删除，0 否，1 是")
    private Integer isDel;
}
