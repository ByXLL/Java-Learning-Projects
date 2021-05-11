package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsEditDto;
import com.brodog.mall.admin.form.goods.GoodsAddForm;
import com.brodog.mall.admin.form.goods.GoodsEditForm;
import com.brodog.mall.admin.form.goods.GoodsEditStateParam;
import com.brodog.mall.admin.form.goods.GoodsSelectParam;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
public interface GoodsService extends IService<Goods> {
    /**
     * 添加商品
     * @param goodsAddForm      商品添加表单 dto
     * @return                  响应数据
     */
    ApiResult addGoods(GoodsAddForm goodsAddForm);

    /**
     * 编辑商品
     * @param goodsEditForm     商品编辑表单  dto
     * @return                  响应数据
     */
    ApiResult editGoods(GoodsEditForm goodsEditForm);

//    /**
//     * 插入商品数据
//     * @param goodsEditDto              商品dto
//     * @return                      响应数据
//     */
//    ApiResult insert(GoodsEditDto goodsEditDto);

    /**
     * 删除商品
     * @param id        商品id
     * @return          响应数据
     */
    ApiResult delete(Long id);

    /**
     * 编辑商品 行数据
     * @param goodsEditDto      商品dto
     * @return                  响应数据
     */
    ApiResult update(GoodsEditDto goodsEditDto);

    /**
     * 编辑商品 状态
     * @param param     商品状态 参数
     * @return          响应数据
     */
    ApiResult updateGoodsState(GoodsEditStateParam param);

    /**
     * 通过id 获取商品
     * @param id        商品id
     * @return          响应数据
     */
    ApiResult selectById(Long id);

    /**
     * 通过 参数选择 查询
     * @param param         商品选择参数 dto
     * @return              响应数据
     */
    ApiResult selectByParam(GoodsSelectParam param);

    /**
     * 通过 商品 id 获取完整的商品详情
     * @param id        商品id
     * @return          响应数据
     */
    ApiResult selectGoodsDetailById(Long id);
}
