package com.brodog.mall.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.brodog.mall.admin.vo.goods.GoodsBranVO;
import com.brodog.mall.admin.vo.goods.GoodsCateVO;
import com.brodog.mall.common.entity.GoodsCate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品分类 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Repository
public interface GoodsCateMapper extends BaseMapper<GoodsCate> {
    /**
     * 自定义 分页查询 方法
     * @param page                  分页对象
     * @param ew                    筛选条件
     * @return                      分页对象
     */
    IPage<GoodsCateVO> selectMyPage(IPage<GoodsCateVO> page, @Param(Constants.WRAPPER) QueryWrapper<GoodsCateVO> ew);
}
