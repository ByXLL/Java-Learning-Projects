package com.brodog.mall.admin.mapper;

import com.brodog.mall.admin.vo.goods.GoodsAttrVO;
import com.brodog.mall.common.entity.GoodsAttr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 商品-属性 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Repository
public interface GoodsAttrMapper extends IPageInterface<GoodsAttr, GoodsAttrVO> {

}
