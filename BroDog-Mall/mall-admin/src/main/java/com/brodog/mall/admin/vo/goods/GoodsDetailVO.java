package com.brodog.mall.admin.vo.goods;

import com.brodog.mall.common.entity.GoodsSku;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 商品详情 vo
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GoodsDetailVO extends GoodsVO {
    @ApiModelProperty(value = "商品-详情")
    private GoodsDescVO descInfo;

    @ApiModelProperty(value = "商品-主图集合")
    private List<GoodsPicVO> mainPicList;

    @ApiModelProperty(value = "商品-sku")
    private List<GoodsSkuVO> sku;
}
