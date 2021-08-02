package com.brodog.mall.app.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.brodog.mall.app.form.goods.GoodsSelectParam;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.Goods;
import com.brodog.mall.common.entity.PagerParam;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
public interface GoodsService extends IService<Goods> {
    /**
     * 查询热卖商品列表
     * @param pagerParam     筛选条件实体
     * @return               响应数据
     */
    ApiResult selectHotList(PagerParam pagerParam);


    /**
     * 通过条件筛选
     * @param param     筛选条件实体
     * @return          响应数据
     */
    ApiResult selectByParam(GoodsSelectParam param);

    /**
     * 通过商品id 获取商品信息
     * @param goodsId       商品id
     * @return              响应数据
     */
    ApiResult selectById(Long goodsId);
}
