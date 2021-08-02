package com.brodog.mall.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.app.form.goods.GoodsSelectParam;
import com.brodog.mall.app.mapper.*;
import com.brodog.mall.app.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.app.vo.goods.*;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.Goods;
import com.brodog.mall.common.entity.GoodsAttr;
import com.brodog.mall.common.entity.PagerParam;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private final GoodsPicsMapper goodsPicsMapper;
    private final GoodsDescMapper goodsDescMapper;
    private final GoodsSkuMapper goodsSkuMapper;
    private final GoodsAttrMapper goodsAttrMapper;
    private final GoodsAttrValueMapper goodsAttrValueMapper;


    public GoodsServiceImpl(GoodsMapper goodsMapper, GoodsCateMapper goodsCateMapper, GoodsBrandMapper goodsBrandMapper, GoodsPicsMapper goodsPicsMapper, GoodsDescMapper goodsDescMapper, GoodsSkuMapper goodsSkuMapper, GoodsAttrMapper goodsAttrMapper, GoodsAttrValueMapper goodsAttrValueMapper) {
        this.goodsMapper = goodsMapper;
        this.goodsCateMapper = goodsCateMapper;
        this.goodsBrandMapper = goodsBrandMapper;
        this.goodsPicsMapper = goodsPicsMapper;
        this.goodsDescMapper = goodsDescMapper;
        this.goodsSkuMapper = goodsSkuMapper;
        this.goodsAttrMapper = goodsAttrMapper;
        this.goodsAttrValueMapper = goodsAttrValueMapper;
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
        QueryWrapper<GoodsVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("g.is_del",0)
                .eq("g.is_sale",1)
                .groupBy("g.id");
        if(StringUtils.isEmpty(param.getName())) { queryWrapper.like("g.name",StringUtils.trim(param.getName()));}
        if(param.getBrandId() != null) { queryWrapper.eq("brand_id",param.getBrandId()); }
        if(param.getCateId() != null) { queryWrapper.eq("cate_id",param.getCateId()); }
        if(param.getSortBy() != null) {
            switch (param.getSortBy()) {
                case 0:
                    queryWrapper.eq("g.is_hot",1).orderByDesc("g.sales");
                    break;
                case 1:
                    queryWrapper.orderByDesc("g.sales");
                    break;
                case 2:
                    queryWrapper.orderByAsc("g.sales");
                    break;
                case 3:
                    queryWrapper.orderByDesc("g.sales");
                    break;
                default:
                    break;
            }
        }
        if((param.getMinPrice() != null) && (param.getMaxPrice() != null)) {
            queryWrapper.between("sell_price",param.getMinPrice(),param.getMaxPrice());
        }


        IPage<GoodsVO> mapPage = goodsMapper.selectMyPage(
                new Page<>(param.getPage(), param.getSize()),
                queryWrapper
        );
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), mapPage);
    }

    /**
     * 通过商品id 获取商品信息
     *
     * @param goodsId 商品id
     * @return 响应数据
     */
    @Override
    public ApiResult selectById(Long goodsId) {
        if(goodsId == null) { throw new ArgException(); }
        Goods goods = goodsMapper.selectById(goodsId);
        if(goods == null) { throw new OperationalException("商品不存在"); }
        List<GoodsPicVO> goodsPics = goodsPicsMapper.selectPicsByGoodsId(goodsId);
        GoodsDescVO goodsDescVO = goodsDescMapper.selectByGoodsId(goodsId);
        List<GoodsSkuVO> goodsSkuVOList = goodsSkuMapper.selectByGoodsId(goodsId);
        List<GoodsAttrValueVO> goodsAttrValueVOList = goodsAttrValueMapper.selectByGoodsId(goods.getId());

        GoodsDetailVO goodsDetailVO = new GoodsDetailVO();
        BeanUtils.copyProperties(goods,goodsDetailVO);
        goodsDetailVO.setDescInfo(goodsDescVO);
        goodsDetailVO.setMainPicList(goodsPics);
        goodsDetailVO.setSku(goodsSkuVOList);
        goodsDetailVO.setAttrList(goodsAttrValueVOList);
        if(goodsAttrValueVOList.size() >0) {
            Long goodsAttrId =  goodsAttrValueVOList.get(0).getGoodsAttrId();
            GoodsAttr goodsAttr = goodsAttrMapper.selectById(goodsAttrId);
            if(goodsAttr != null) {
                goodsDetailVO.setGoodsAttrCateId(goodsAttr.getGoodsAttrCateId());
            }
        }

        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),goodsDetailVO);
    }

}
