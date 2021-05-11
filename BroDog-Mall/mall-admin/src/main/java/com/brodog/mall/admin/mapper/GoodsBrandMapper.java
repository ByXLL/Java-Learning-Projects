package com.brodog.mall.admin.mapper;

import com.brodog.mall.admin.vo.goods.GoodsBranVO;
import com.brodog.mall.common.entity.GoodsBrand;
import org.springframework.stereotype.Repository;


/**
 * <p>
 * 商品品牌 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Repository
public interface GoodsBrandMapper extends IPageInterface<GoodsBrand,GoodsBranVO> {
}
