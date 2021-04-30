package com.brodog.mall.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.vo.goods.GoodsAttrValueVO;
import com.brodog.mall.admin.vo.goods.GoodsSpecVO;
import com.brodog.mall.common.entity.GoodsAttrValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品属性-属性值表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Repository
public interface GoodsAttrValueMapper extends BaseMapper<GoodsAttrValue> {
    /**
     * 自定义 分页查询 方法
     * @param page                  分页对象
     * @param ew                    筛选条件
     * @return                      分页对象
     */
    IPage<GoodsAttrValueVO> selectMyPage(Page<GoodsAttrValueVO> page, @Param(Constants.WRAPPER) QueryWrapper<GoodsAttrValueVO> ew);
}
