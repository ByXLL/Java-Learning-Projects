package com.brodog.mall.admin.mapper;

import com.brodog.mall.admin.vo.goods.GoodsDescVO;
import com.brodog.mall.common.entity.GoodsDesc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品详情表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
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
