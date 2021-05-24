package com.brodog.mall.admin.dto.goods;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品属性分类 编辑dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsAttrCateEditDto {
    @ApiModelProperty(value = "商品-属性分类id")
    @NotNull(message = "属性分类id为空")
    private Long id;

    @ApiModelProperty(value = "属性分类名称",required = true)
    private String name;

    @ApiModelProperty(value = "属性个数",required = true)
    private Integer attrCount;

    @ApiModelProperty(value = "规格个数",required = true)
    private Integer specCount;

    @ApiModelProperty(value = "是否删除，0 否，1 是")
    private Integer isDel;
}
