package com.brodog.mall.app.form.goods;

import com.brodog.mall.common.entity.PagerParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 商品选择 参数实体
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GoodsSelectParam extends PagerParam {
    @ApiModelProperty(value = "商品 名称")
    private String name;

    @ApiModelProperty(value = "商品品牌 id")
    private Long brandId;

    @ApiModelProperty(value = "商品分类 id")
    private Long cateId;

    @ApiModelProperty(value = "最小价格")
    private BigDecimal minPrice;

    @ApiModelProperty(value = "最大价格")
    private BigDecimal maxPrice;

    @ApiModelProperty(value = "排序条件：0->综合、1->销量、2->价格升序、3->价格降序")
    private Integer sortBy;
}
