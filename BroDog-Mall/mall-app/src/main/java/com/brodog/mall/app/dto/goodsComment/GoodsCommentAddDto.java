package com.brodog.mall.app.dto.goodsComment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 商品评论
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GoodsComment对象add dto", description="商品评论添加dto")
public class GoodsCommentAddDto implements Serializable {

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id为空")
    private Long userId;

    @ApiModelProperty(value = "商品id")
    @NotNull(message = "商品id为空")
    private Long goodsId;

    @ApiModelProperty(value = "五星点赞")
    private Integer start;

    @ApiModelProperty(value = "评论内容")
    private String content;

}
