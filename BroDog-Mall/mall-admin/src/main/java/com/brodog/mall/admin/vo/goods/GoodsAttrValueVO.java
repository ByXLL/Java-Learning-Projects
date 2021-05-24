package com.brodog.mall.admin.vo.goods;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品属性值 vo
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsAttrValueVO {
    @ApiModelProperty(value = "商品-属性值-id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "商品id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long goodsId;

    @ApiModelProperty(value = "商品属性 id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long goodsAttrId;

    @ApiModelProperty(value = "属性值")
    private String value;
}
