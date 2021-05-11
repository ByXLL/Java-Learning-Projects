package com.brodog.mall.admin.dto.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品图片 新增 dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsPicsAddDto {
    @ApiModelProperty(value = "商品id")
    @NotNull(message = "商品id 为空")
    private Long goodsId;

    @ApiModelProperty(value = "图片url地址")
    @NotEmpty(message = "图片url地址为空")
    private String url;
}
