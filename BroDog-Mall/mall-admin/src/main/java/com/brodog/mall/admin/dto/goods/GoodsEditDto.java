package com.brodog.mall.admin.dto.goods;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品 编辑 dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsEditDto {
    @ApiModelProperty(value = "商品id")
    @NotNull(message = "商品id 为空")
    private Long id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "副标题")
    private String subtitle;

    @ApiModelProperty(value = "分类id")
    private Long cateId;

    @ApiModelProperty(value = "品牌id")
    private Long brandId;

    @ApiModelProperty(value = "销量")
    private Integer sales;

    @ApiModelProperty(value = "库存量")
    private Integer inventory;

    @ApiModelProperty(value = "售价")
    private BigDecimal sellPrice;

    @ApiModelProperty(value = "市场价")
    private BigDecimal marketPrice;

    @ApiModelProperty(value = "计量单位")
    private String unit;

    @ApiModelProperty(value = "重量")
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
