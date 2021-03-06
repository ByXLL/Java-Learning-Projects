package com.brodog.mall.admin.mapper;

import com.brodog.mall.admin.vo.goods.GoodsAttrValueVO;
import com.brodog.mall.common.entity.GoodsAttrValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 商品属性-属性值表 Mapper 接口
 * </p>
 *
 * @author By-Lin
 * @since 2021-05-24
 */
@Repository
public interface GoodsAttrValueMapper extends BaseMapper<GoodsAttrValue> {
//    /**
//     * 批量添加商品属性值
//     * @param goodsAttrValueList        商品属性值 列表
//     * @return                          响应数据
//     */
//    Integer insertBatch(List<GoodsAttrValue> goodsAttrValueList);

    /**
     * 通过商品id 查询 商品属性值集合
     * @param goodsId           商品id
     * @return                  商品属性值vo 集合
     */
    List<GoodsAttrValueVO> selectByGoodsId(Long goodsId);
}
