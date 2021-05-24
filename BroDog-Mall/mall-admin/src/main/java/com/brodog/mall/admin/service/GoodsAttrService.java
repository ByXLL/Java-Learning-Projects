package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsAttrAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrEditDto;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttr;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brodog.mall.common.entity.PagerParam;

/**
 * <p>
 * 商品属性表 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
public interface GoodsAttrService extends IService<GoodsAttr> {
    /**
     * 添加商品属性
     * @param goodsAttrAddDto     商品属性添加 dto
     * @return                    响应数据
     */
    ApiResult insert(GoodsAttrAddDto goodsAttrAddDto);

    /**
     * 删除 商品属性
     * @param id        商品属性id
     * @return          响应数据
     */
    ApiResult delete(Long id);

    /**
     * 修改 商品属性
     * @param goodsAttrEditDto              商品属性编辑 dto
     * @return                              响应数据
     */
    ApiResult update(GoodsAttrEditDto goodsAttrEditDto);

    /**
     * 分页查询
     * @param pagerParam        分页对象
     * @return                  响应数据
     */
    ApiResult selectByPage(PagerParam pagerParam);

    /**
     * 通过id 获取商品属性
     * @param id        商品属性id
     * @return          响应数据
     */
    ApiResult selectById(Long id);

    /**
     * 通过 属性分类id 获取属性 集合
     * @param attrCateId        属性分类id
     * @return                  响应数据
     */
    ApiResult selectByAttrCateId(Long attrCateId);
}
