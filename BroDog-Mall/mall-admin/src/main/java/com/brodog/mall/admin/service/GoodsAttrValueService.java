package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsAttrValueAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrValueEditDto;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttrValue;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brodog.mall.common.entity.PagerParam;

/**
 * <p>
 * 商品属性-属性值表 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
public interface GoodsAttrValueService extends IService<GoodsAttrValue> {
    /**
     * 添加商品属性值
     * @param goodsAttrValueAddDto     商品属性值 dto
     * @return                         响应数据
     */
    ApiResult insert(GoodsAttrValueAddDto goodsAttrValueAddDto);

    /**
     * 删除 商品属性值
     * @param id        商品属性值
     * @return          响应数据
     */
    ApiResult delete(Long id);

    /**
     * 修改 商品属性值
     * @param goodsAttrValueEditDto         商品属性值 dto
     * @return                              响应数据
     */
    ApiResult update(GoodsAttrValueEditDto goodsAttrValueEditDto);

    /**
     * 分页查询
     * @param pagerParam        分页对象
     * @return                  响应数据
     */
    ApiResult selectByPage(PagerParam pagerParam);

    /**
     * 通过id 获取商品属性值
     * @param id        商品属性值id
     * @return          响应数据
     */
    ApiResult selectById(Long id);

    /**
     * 通过 属性id 获取属性值 集合
     * @param id        属性id
     * @return          响应数据
     */
    ApiResult selectByAttrId(Long id);
}
