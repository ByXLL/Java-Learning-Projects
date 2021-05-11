package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsSpecAddDto;
import com.brodog.mall.admin.dto.goods.GoodsSpecEditDto;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsSpec;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brodog.mall.common.entity.PagerParam;

/**
 * <p>
 * 商品-规格 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
public interface GoodsSpecService extends IService<GoodsSpec> {
    /***
     * 添加 商品规格
     * @param goodsSpecAddDto      商品规格dto
     * @return                     响应数据
     */
    ApiResult insert(GoodsSpecAddDto goodsSpecAddDto);

    /**
     * 删除商品规格
     * @param goodsSpecId       商品规格id
     * @return                  响应数据
     */
    ApiResult delete(Long goodsSpecId);

    /**
     * 修改商品规格
     * @param goodsSpecEditDto      商品规格dto
     * @return                      响应数据
     */
    ApiResult update(GoodsSpecEditDto goodsSpecEditDto);

    /**
     * 分页查询 规格
     * @param pagerParam        分页对象
     * @return                  响应数据
     */
    ApiResult selectByPage(PagerParam pagerParam);

    /**
     * 通过 id 查询
     * @param id        规格 id
     * @return          响应数据
     */
    ApiResult selectById(Long id);

    /**
     * 通过 属性id 获取属性值
     * @param id        属性id
     * @return          响应数据
     */
    ApiResult selectByAttrId(Long id);
}
