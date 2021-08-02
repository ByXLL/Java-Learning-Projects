package com.brodog.mall.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brodog.mall.app.vo.goods.GoodsAttrValueVO;
import com.brodog.mall.common.entity.GoodsAttrValue;

import java.util.List;

/**
 * <p>
 * 商品属性-属性值表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
public interface GoodsAttrValueMapper extends BaseMapper<GoodsAttrValue> {
    /**
     * 通过商品id 查询 商品属性值集合
     * @param goodsId           商品id
     * @return                  商品属性值vo 集合
     */
    List<GoodsAttrValueVO> selectByGoodsId(Long goodsId);
}
