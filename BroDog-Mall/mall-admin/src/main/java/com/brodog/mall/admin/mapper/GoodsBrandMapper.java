package com.brodog.mall.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.brodog.mall.admin.vo.goods.GoodsBranVO;
import com.brodog.mall.common.entity.GoodsBrand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brodog.mall.common.entity.PagerParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 商品品牌 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Repository
public interface GoodsBrandMapper extends BaseMapper<GoodsBrand> {
    /**
     * 自定义 分页查询 方法
     * @param page                  分页参数对象
     * @param queryWrapper          筛选条件
     * @return                      分页对象
     */
    IPage<GoodsBranVO> selectMyPage(IPage<GoodsBranVO> page, @Param(Constants.WRAPPER) Wrapper<GoodsBrand> queryWrapper);

    List<GoodsBranVO> testSql();

}
