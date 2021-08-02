package com.brodog.mall.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brodog.mall.app.vo.goods.GoodsDescVO;
import com.brodog.mall.common.entity.GoodsDesc;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品详情表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
@Repository
public interface GoodsDescMapper extends BaseMapper<GoodsDesc> {
    /**
     * 通过商品id 获取商品详情
     * @param goodsId       商品id
     * @return              商品详情 vo
     */
    GoodsDescVO selectByGoodsId(Long goodsId);
}
