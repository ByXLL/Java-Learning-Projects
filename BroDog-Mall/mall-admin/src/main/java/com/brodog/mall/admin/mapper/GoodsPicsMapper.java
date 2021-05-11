package com.brodog.mall.admin.mapper;

import com.brodog.mall.admin.vo.goods.GoodsPicVO;
import com.brodog.mall.common.entity.GoodsPics;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Repository
public interface GoodsPicsMapper extends BaseMapper<GoodsPics> {
    /**
     * 通过 商品id 获取商品的所有图片集合
     * @param goodsId       商品id
     * @return              图片地址集合
     */
    List<GoodsPicVO> selectPicsByGoodsId(Long goodsId);

    /**
     * 通过商品id删除该商品下的图片
     * @param goodsId       商品id
     * @return              影响行数
     */
    Integer deleteByGoodsId(Long goodsId);
}
