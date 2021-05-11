package com.brodog.mall.admin.form.goods;

import com.brodog.mall.common.entity.PagerParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 商品选择 参数实体
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GoodsSelectParam extends PagerParam {
    @ApiModelProperty(value = "商品 id")
    private Long id;

    @ApiModelProperty(value = "商品 名称")
    private String name;

    @ApiModelProperty(value = "商品分类 id")
    private Long cateId;

    @ApiModelProperty(value = "审核状态，0未通过，1 通过")
    private Integer verifyStatus;

    @ApiModelProperty(value = "商品品牌 id")
    private Long brandId;

    @ApiModelProperty(value = "是否 热销 0否，1是")
    private Integer isHot;

    @ApiModelProperty(value = "是否 预售商品 0否， 1是")
    private Integer isPreSale;

    @ApiModelProperty(value = "是否 上架 0否， 1是")
    private Integer isSale;
}
