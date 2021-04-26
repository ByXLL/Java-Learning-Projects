package com.brodog.mall.admin.vo.goods;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 商品品牌 vo
 * @author By-Lin
 */
@Data
public class GoodsBranVO {
    @ApiModelProperty(value = "品牌名称")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty(value = "品牌名称")
    private String name;

    @ApiModelProperty(value = "品牌首字母")
    private String firstLetter;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "是否显示，0 否，1 是")
    private Integer isShow;

    @ApiModelProperty(value = "logo")
    private String logo;

    @ApiModelProperty(value = "品牌专区 图片")
    private String bigPic;
}
