package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsAttrDto;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttr;
import com.brodog.mall.common.exception.OperationalException;

/**
 * <p>
 * 商品-属性 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
public interface GoodsAttrService extends IService<GoodsAttr> {
    /**
     * 添加 商品属性
     * @param goodsAttrDto     商品属性表单
     * @return                 响应数据
     */
    ApiResult insert(GoodsAttrDto goodsAttrDto);

    /**
     * 通过 id 删除商品属性
     * @param goodsAttrId       商品属性id
     * @return                  响应数据
     */
    ApiResult delete(Long goodsAttrId);

    /**
     * 修改 商品属性
     * @param goodsAttrDto      商品属性dto
     * @return                  响应数据
     */
    ApiResult update(GoodsAttrDto goodsAttrDto);

    /**
     * 查询所有
     * @return      响应数据
     */
    ApiResult selectAll();

    /**
     * 通过 品牌名字 搜索
     * @param name      品牌名字
     * @return          响应数据
     */
    ApiResult selectByName(String name);

    /**
     * 通过 id 获取品牌详情
     * @param id        品牌id
     * @return          响应数据
     */
    ApiResult selectById(Long id);
}
