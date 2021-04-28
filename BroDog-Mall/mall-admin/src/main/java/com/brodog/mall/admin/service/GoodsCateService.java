package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsCateDto;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsCate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.brodog.mall.common.entity.PagerParam;

/**
 * <p>
 * 商品分类 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
public interface GoodsCateService extends IService<GoodsCate> {
    /**
     * 添加商品分类
     * @param goodsCateDto      商品分类dto
     * @return                  响应数据
     */
    ApiResult insert(GoodsCateDto goodsCateDto);

    /**
     * 删除商品分类
     * @param id        商品id
     * @return          响应数据
     */
    ApiResult delete(Long id);

    /**
     * 编辑商品分类
     * @param goodsCateDto      商品分类dto
     * @return                  响应数据
     */
    ApiResult update(GoodsCateDto goodsCateDto);

    /**
     * 分页查询 商品分类
     * @param pagerParam        分类参数
     * @param name              分类名称
     * @return                  响应数据
     */
    ApiResult selectByPage(PagerParam pagerParam, String name);

    /**
     * 通过 id 查询
     * @param id        分类id
     * @return          响应数据
     */
    ApiResult selectById(Long id);

}
