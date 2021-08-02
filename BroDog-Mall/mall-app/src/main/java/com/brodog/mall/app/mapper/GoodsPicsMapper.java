package com.brodog.mall.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brodog.mall.app.vo.goods.GoodsPicVO;
import com.brodog.mall.common.entity.GoodsPics;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
@Repository
public interface GoodsPicsMapper extends BaseMapper<GoodsPics> {
    /**
     * 通过 商品id 获取商品的所有图片集合
     * @param goodsId       商品id
     * @return              图片地址集合
     */
    List<GoodsPicVO> selectPicsByGoodsId(Long goodsId);
}
