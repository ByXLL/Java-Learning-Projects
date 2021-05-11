package com.brodog.mall.admin.dto.goods;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 商品详情 编辑 dto
 * @author By-Lin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDescEditDto {
    @ApiModelProperty(value = "主键")
    @NotNull( message = "id 为空")
    private Long id;

    @ApiModelProperty(value = "商品id")
    @NotNull(message = "商品id 为空")
    private Long goodsId;

    @ApiModelProperty(value = "副标题")
    private String subtitle;

    @ApiModelProperty(value = "积分")
    private Double integral;

    @ApiModelProperty(value = "成长值")
    private Double growthValue;

    @ApiModelProperty(value = "详细页标题")
    private String descTitle;

    @ApiModelProperty(value = "详情")
    private String desc;

    @ApiModelProperty(value = "关键字")
    private String keyword;

    @ApiModelProperty(value = "备注")
    private String remarks;
}
