package com.brodog.mall.admin.mapper;

import com.brodog.mall.admin.vo.goods.GoodsSkuVO;
import com.brodog.mall.common.entity.GoodsSku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 商品SKU表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
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
