package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsSkuAddDto;
import com.brodog.mall.admin.dto.goods.GoodsSkuEditDto;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsSku;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.Valid;

/**
 * <p>
 * 商品SKU表 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
public interface GoodsSkuService extends IService<GoodsSku> {

    /**
     * 添加商品sku
     * @param goodsSkuAddDto           sku 新增 dto
     * @return                         响应数据
     */
    ApiResult insert(@Valid GoodsSkuAddDto goodsSkuAddDto);

    /**
     * 删除 sku
     * @param id        sku id
     * @return          响应数据
     */
    ApiResult delete(Long id);

    /**
     *  通过商品id 删除商品 sku
     * @param goodsId       商品id
     * @return              响应数据
     */
    ApiResult deleteByGoodsId(Long goodsId);

    /**
     * 通过商品id 字符串集合删除  商品sku
     * @param goodsIds          商品id 字符串
     * @return                  响应数据
     */
    ApiResult deleteByGoodsIds(String goodsIds);

    /**
     * 编辑商品 sku
     * @param goodsSkuEditDto       sku 编辑 dto
     * @return                      响应数据
     */
    ApiResult update(GoodsSkuEditDto goodsSkuEditDto);

    /**
     * 通过 id 获取商品sku
     * @param id            商品 sku id
     * @return              响应数据
     */
    ApiResult selectById(Long id);

    /**
     * 通过商品id 获取商品 sku
     * @param goodsId       商品id
     * @return              响应数据
     */
    ApiResult selectByGoodsId(Long goodsId);


    /**
     * 通过商品 sku 编号 获取sku
     * @param skuNumber         sku 编号
     * @return                  响应数据
     */
    ApiResult selectBySkuNumber(Integer skuNumber);
}
