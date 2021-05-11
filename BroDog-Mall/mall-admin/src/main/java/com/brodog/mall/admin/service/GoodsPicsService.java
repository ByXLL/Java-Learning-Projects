package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsPicsAddDto;
import com.brodog.mall.admin.dto.goods.GoodsPicsEditDto;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsPics;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
public interface GoodsPicsService extends IService<GoodsPics> {
    /**
     * 商品图片 dto
     * @param goodsPicsAddDto      商品图片 新增 dto
     * @return                     响应数据
     */
    ApiResult insert(GoodsPicsAddDto goodsPicsAddDto);

    /**
     * 删除图片
     * @param id        图片id
     * @return          响应数据
     */
    ApiResult delete(Long id);

    /**
     * 通过商品 id 获取商品图片
     * @param id  商品id
     * @return    响应数据
     */
    ApiResult selectByGoodsId(Long id);
}
