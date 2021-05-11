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
public interface GoodsCateMapper extends IPageInterface<GoodsCate,GoodsCateVO> {
}
