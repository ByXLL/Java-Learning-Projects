package com.brodog.mall.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.brodog.mall.admin.vo.goods.GoodsCateVO;
import org.apache.ibatis.annotations.Param;

/**
 * 自定义分页接口
 * 将实体和当前实体的vo传入 用于分页返回自定义vo
 * 继承自 BaseMapper
 * @author By-Lin
 */
public interface IPageInterface<T,TVO> extends BaseMapper<T> {
    /**
     * 自定义 分页查询 方法
     * @param page                  分页对象
     * @param ew                    筛选条件
     * @return                      分页对象
     */
    IPage<TVO> selectMyPage(IPage<TVO> page, @Param(Constants.WRAPPER) QueryWrapper<TVO> ew);
}
