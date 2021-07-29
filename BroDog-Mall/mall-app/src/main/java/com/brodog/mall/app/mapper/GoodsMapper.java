package com.brodog.mall.app.mapper;

import com.brodog.mall.app.vo.goods.GoodsVO;
import com.brodog.mall.common.entity.Goods;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
@Repository
public interface GoodsMapper extends IPageInterface<Goods, GoodsVO> {

}
