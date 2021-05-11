package com.brodog.mall.admin.mapper;


import com.brodog.mall.admin.vo.goods.GoodsSpecVO;
import com.brodog.mall.common.entity.GoodsSpec;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品-规格 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Repository
public interface GoodsSpecMapper extends IPageInterface<GoodsSpec,GoodsSpecVO> {
}
