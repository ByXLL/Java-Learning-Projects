package com.brodog.mall.admin.form.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 商品编辑 状态参数
 * @author By-Lin
 */
@Data
public class GoodsEditStateParam {
    @ApiModelProperty(value = "商品id")
    @NotNull(message = "商品id 为空")
    private Long id;

    @ApiModelProperty(value = "审核状态，0未通过，1 通过")
    private Integer verifyStatus;

    @ApiModelProperty(value = "是否推荐， 0 否，1 是")
    private Integer isHot;

    @ApiModelProperty(value = "是否预售商品，0 否，1 是")
    private Integer isPreSale;

    @ApiModelProperty(value = "是否上架，0 否，1 是")
    private Integer isSale;
}
