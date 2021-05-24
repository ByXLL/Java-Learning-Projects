package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsAttrCateAddDto;
import com.brodog.mall.admin.dto.goods.GoodsAttrCateEditDto;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttrCate;
import com.brodog.mall.common.entity.PagerParam;

/**
 * <p>
 * 商品-属性分类 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
public interface GoodsAttrCateService extends IService<GoodsAttrCate> {
    /**
     * 添加 商品属性分类
     * @param goodsAttrCateAddDtoDto     商品属性分类添加表单
     * @return                       响应数据
     */
    ApiResult insert(GoodsAttrCateAddDto goodsAttrCateAddDtoDto);

    /**
     * 通过 id 删除商品属性分类
     * @param goodsAttrCateId       商品属性分类id
     * @return                  响应数据
     */
    ApiResult delete(Long goodsAttrCateId);

    /**
     * 修改 商品属性分类
     * @param goodsAttrCateEditDto      商品属性分类 编辑dto
     * @return                      响应数据
     */
    ApiResult update(GoodsAttrCateEditDto goodsAttrCateEditDto);

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
     * 通过 id 获取属性分类详情
     * @param id        属性分类id
     * @return          响应数据
     */
    ApiResult selectById(Long id);

    /**
     * 分页查询 属性
     * @param pagerParam      分页对象
     * @param name            属性分类名
     * @return                响应数据
     */
    ApiResult selectByPage(PagerParam pagerParam, String name);

}
