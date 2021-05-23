package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsAttrAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrEditDto;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttr;
import com.brodog.mall.common.entity.PagerParam;

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
     * @param goodsAttrAddDtoDto     商品属性添加表单
     * @return                       响应数据
     */
    ApiResult insert(GoodsAttrAddDto goodsAttrAddDtoDto);

    /**
     * 通过 id 删除商品属性
     * @param goodsAttrId       商品属性id
     * @return                  响应数据
     */
    ApiResult delete(Long goodsAttrId);

    /**
     * 修改 商品属性
     * @param goodsAttrEditDto      商品属性 编辑dto
     * @return                      响应数据
     */
    ApiResult update(GoodsAttrEditDto goodsAttrEditDto);

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

    /**
     * 分页查询 属性
     * @param pagerParam      分页对象
     * @param name            属性名
     * @return                响应数据
     */
    ApiResult selectByPage(PagerParam pagerParam, String name);

}
