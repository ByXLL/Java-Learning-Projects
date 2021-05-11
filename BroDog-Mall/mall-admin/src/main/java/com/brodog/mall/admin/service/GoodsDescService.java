package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsDescAddDto;
import com.brodog.mall.admin.dto.goods.GoodsDescEditDto;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsDesc;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.validation.Valid;

/**
 * <p>
 * 商品详情表 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
public interface GoodsDescService extends IService<GoodsDesc> {
    /**
     * 添加商品 详情信息
     * @param goodsDescAddDto      商品详情表 新增 dto
     * @return                     响应数据
     */
    ApiResult insert(@Valid GoodsDescAddDto goodsDescAddDto);

    /**
     * 删除商品详情
     * @param id        详情id
     * @return          响应数据
     */
    ApiResult delete(Long id);

    /**
     * 编辑商品详情
     * @param goodsDescEditDto      商品详情 编辑 dto
     * @return                      响应数据
     */
    ApiResult update(GoodsDescEditDto goodsDescEditDto);

    /**
     * 通过id查询 商品详情
     * @param id       商品详情 id
     * @return         响应数据
     */
    ApiResult selectById(Long id);

    /**
     * 通过商品id 查询商品详情
     * @param   goodsId        商品id
     * @return                 响应数据
     */
    ApiResult selectByGoodsId(Long goodsId);
}
