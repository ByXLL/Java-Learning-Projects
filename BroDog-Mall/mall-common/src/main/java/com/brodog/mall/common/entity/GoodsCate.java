package com.brodog.mall.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GoodsCate对象", description="商品分类")
public class GoodsCate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品分类id")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "上级分类")
    private Long pid;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "商品个数")
    private Integer count;

    @ApiModelProperty(value = "分类等级，1 一级，2 二级")
    private Integer level;

    @ApiModelProperty(value = "数量单位")
    private String unit;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "关键词")
    private String keyword;

    @ApiModelProperty(value = "描述")
    private String desc;

    @ApiModelProperty(value = "是否显示，0 否，1 是")
    private Integer isShow;

    @ApiModelProperty(value = "是否导航栏显示，0 否，1 是")
    private Integer isMenu;

    @ApiModelProperty(value = "是否删除，0 否，1 是")
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Timestamp updateTime;


}
