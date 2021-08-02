package com.brodog.mall.app.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brodog.mall.app.vo.goods.GoodsSkuVO;
import com.brodog.mall.common.entity.GoodsSku;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 商品SKU表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
@Repository
public interface GoodsSkuMapper extends BaseMapper<GoodsSku> {
    /**
     * 通过 商品id 获取
     * @param goodsId   商品id
     * @return          商品sku list
     */
    List<GoodsSkuVO> selectByGoodsId(Long goodsId);
}
