package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsAttrValueAddDto;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttrValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品属性-属性值表 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-05-24
 */
public interface GoodsAttrValueService extends IService<GoodsAttrValue> {

    /**
     * 新增 商品属性值
     * @param attrValueAddDto       商品属性值新增 dto
     * @return                      响应数据
     */
    ApiResult insert(GoodsAttrValueAddDto attrValueAddDto);

    /**
     * 批量新增 商品属性值
     * @param addDtoList      商品属性值 新增 dto 数组
     * @return                响应数据
     */
    ApiResult insertBatch(List<GoodsAttrValueAddDto> addDtoList);

    /**
     * 通过商品id 删除所有属性值
     * @param goodsId       商品id
     * @return              响应数据
     */
    ApiResult deleteByGoodsId(Long goodsId);

    /**
     * 通过商品属性 id删除所有属性值
     * @param attrId            属性 id
     * @return                  响应数据
     */
    ApiResult deleteByAttrId(Long attrId);

    /**
     * 通过 属性值id 删除
     * @param id        属性值id
     * @return          响应数据
     */
    ApiResult deleteById(Long id);

    /**
     * 通过属性值id  获取商品
     * @param id        属性值id
     * @return          响应数据
     */
    ApiResult selectById(Long id);

    /**
     * 通过商品id 获取商品属性值
     * @param  goodsId   商品id
     * @return           响应数据
     */
    ApiResult selectByGoodsId(Long goodsId);
}
