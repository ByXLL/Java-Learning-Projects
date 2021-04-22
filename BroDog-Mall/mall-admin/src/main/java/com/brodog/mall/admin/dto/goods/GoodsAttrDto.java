package com.brodog.mall.admin.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品属性 表单数据
 * @author By-Lin
 */
@Data
public class GoodsAttrDto {
    @ApiModelProperty(value = "属性名称",required = true)
    @NotEmpty(message = "属性名称为空")
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
