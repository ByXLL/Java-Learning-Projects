package com.brodog.mall.app.form.goodsComment;

import com.brodog.mall.common.entity.PagerParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 商品评论 查询参数
 * @author By-Lin
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsCommentSelectParam extends PagerParam {
    @ApiModelProperty(value = "商品id")
    @NotNull(message = "商品id不能为空")
    private Long goodsId;

    @ApiModelProperty(value = "评论等级：1->好评, 2-> 中评, 差评->3")
    private Integer grade;
}
