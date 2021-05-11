package com.brodog.mall.admin.dto.goods;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品图片 编辑 dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsPicsEditDto {
    @ApiModelProperty(value = "主键")
    @NotNull(message = "id 为空")
    private Long id;

    @ApiModelProperty(value = "商品id")
    @NotNull(message = "商品id 为空")
    private Long goodsId;

    @ApiModelProperty(value = "图片url地址")
    @NotEmpty(message = "图片url地址为空")
    private String url;
}
