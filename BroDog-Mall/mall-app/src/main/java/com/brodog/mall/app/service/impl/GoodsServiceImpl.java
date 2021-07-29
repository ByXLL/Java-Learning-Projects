package com.brodog.mall.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.app.form.goods.GoodsSelectParam;
import com.brodog.mall.app.mapper.GoodsBrandMapper;
import com.brodog.mall.app.mapper.GoodsCateMapper;
import com.brodog.mall.app.mapper.GoodsMapper;
import com.brodog.mall.app.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.app.vo.goods.GoodsVO;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.Goods;
import com.brodog.mall.common.entity.PagerParam;
import com.brodog.mall.common.enums.HttpCodeEnum;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-07-01
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    private final GoodsMapper goodsMapper;
    private final GoodsCateMapper goodsCateMapper;
    private final GoodsBrandMapper goodsBrandMapper;

    public GoodsServiceImpl(GoodsMapper goodsMapper, GoodsCateMapper goodsCateMapper, GoodsBrandMapper goodsBrandMapper) {
        this.goodsMapper = goodsMapper;
        this.goodsCateMapper = goodsCateMapper;
        this.goodsBrandMapper = goodsBrandMapper;
    }


    /**
     * 查询热卖商品列表
     *
     * @param pagerParam        分页参数
     * @return 响应数据
     */
    @Override
    public ApiResult selectHotList(PagerParam pagerParam) {
        QueryWrapper<GoodsVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("g.is_del",0)
                .eq("g.is_hot",1)
                .eq("g.is_sale",1)
                .groupBy("g.id");
        IPage<GoodsVO> mapPage = goodsMapper.selectMyPage(
                new Page<>(pagerParam.getPage(), pagerParam.getSize()),
                queryWrapper
        );
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), mapPage);
    }

    /**
     * 通过条件筛选
     *
     * @param param 筛选条件实体
     * @return 响应数据
     */
    @Override
    public ApiResult selectByParam(GoodsSelectParam param) {
        return null;
    }

    /**
     * 通过商品id 获取商品信息
     *
     * @param goodsId 商品id
     * @return 响应数据
     */
    @Override
    public ApiResult selectById(Long goodsId) {
        return null;
    }

}
