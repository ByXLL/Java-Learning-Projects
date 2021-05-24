package com.brodog.mall.admin.form.goods;

import com.brodog.mall.admin.dto.goods.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * 商品 表单 dto
 * @author By-Lin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsAddForm {
    @Valid
    @ApiModelProperty(value = "商品-基本信息")
    @NotNull(message = "商品基本信息为空")
    private GoodsAddDto goodsBasisInfo;

    @Valid
    @ApiModelProperty(value = "商品-详情")
    @NotNull(message = "商品详细信息为空")
    private GoodsDescAddDto goodsDescInfo;

    @ApiModelProperty(value = "商品-主图")
    @Size(min = 1, message = "商品图片为空")
    @NotNull(message = "商品图片为空")
    private List<String> mainPicList;

    @Valid
    @ApiModelProperty(value = "商品-sku")
    @NotNull(message = "商品sku信息为空")
    @Size(min = 1, message = "商品sku信息为空")
    private List<GoodsSkuAddDto> skuList;

    @Valid
    @ApiModelProperty(value = "商品-属性值集合")
    @NotNull(message = "商品属性值为空")
    @Size(min = 1, message = "商品属性值为空")
    private List<GoodsAttrValueAddDto> attrList;
}
