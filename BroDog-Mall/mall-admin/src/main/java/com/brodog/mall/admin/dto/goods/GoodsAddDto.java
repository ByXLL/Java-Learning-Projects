package com.brodog.mall.admin.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 商品 新增 dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsAddDto {
    @ApiModelProperty(value = "商品名称")
    @NotEmpty(message = "商品名称为空")
    private String name;

    @ApiModelProperty(value = "副标题")
    @NotEmpty(message = "副标题为空")
    private String subtitle;

    @ApiModelProperty(value = "分类id")
    @NotNull(message = "分类id为空")
    private Long cateId;

    @ApiModelProperty(value = "品牌id")
    @NotNull(message = "品牌id为空")
    private Long brandId;

    @ApiModelProperty(value = "销量")
    @NotNull(message = "销量为空")
    private Integer sales;

    @ApiModelProperty(value = "库存量")
    @NotNull(message = "库存量为空")
    private Integer inventory;

    @ApiModelProperty(value = "售价")
    @NotNull(message = "售价为空")
    private BigDecimal sellPrice;

    @ApiModelProperty(value = "市场价")
    @NotNull(message = "市场价为空")
    private BigDecimal marketPrice;

    @ApiModelProperty(value = "计量单位")
    private String unit;

    @ApiModelProperty(value = "重量")
    @NotNull(message = "重量为空")
    private Double weight;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "审核状态，0未通过，1 通过")
    private Integer verifyStatus;

    @ApiModelProperty(value = "是否推荐， 0 否，1 是")
    private Integer isHot;

    @ApiModelProperty(value = "是否预售商品，0 否，1 是")
    private Integer isPreSale;

    @ApiModelProperty(value = "是否上架，0 否，1 是")
    private Integer isSale;

}
