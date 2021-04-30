package com.brodog.mall.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.vo.goods.GoodsBranVO;
import com.brodog.mall.admin.vo.goods.GoodsSpecVO;
import com.brodog.mall.common.entity.GoodsSpec;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品-规格 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Repository
public interface GoodsSpecMapper extends BaseMapper<GoodsSpec> {
    /**
     * 自定义 分页查询 方法
     * @param page                  分页对象
     * @param ew                    筛选条件
     * @return                      分页对象
     */
    IPage<GoodsSpecVO> selectMyPage(Page<GoodsSpecVO> page, @Param(Constants.WRAPPER) QueryWrapper<GoodsSpecVO> ew);

}
