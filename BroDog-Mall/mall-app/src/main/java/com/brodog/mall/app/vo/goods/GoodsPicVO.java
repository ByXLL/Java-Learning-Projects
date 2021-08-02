package com.brodog.mall.app.vo.goods;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品图片 vo
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsPicVO {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "图片url地址")
    private String url;
}
