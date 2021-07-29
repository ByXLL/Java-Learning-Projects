package com.brodog.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brodog.mall.admin.dto.goods.*;
import com.brodog.mall.admin.form.goods.GoodsAddForm;
import com.brodog.mall.admin.form.goods.GoodsEditForm;
import com.brodog.mall.admin.form.goods.GoodsEditStateParam;
import com.brodog.mall.admin.form.goods.GoodsSelectParam;
import com.brodog.mall.admin.mapper.*;
import com.brodog.mall.admin.vo.goods.*;
import com.brodog.mall.common.entity.*;
import com.brodog.mall.admin.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brodog.mall.common.enums.HttpCodeEnum;
import com.brodog.mall.common.exception.ArgException;
import com.brodog.mall.common.exception.OperationalException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author By-Lin
 * @since 2021-04-21
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    private final GoodsMapper goodsMapper;
    private final GoodsPicsMapper goodsPicsMapper;
    private final GoodsDescMapper goodsDescMapper;
    private final GoodsSkuMapper goodsSkuMapper;
    private final GoodsCateMapper goodsCateMapper;
    private final GoodsAttrMapper goodsAttrMapper;
    private final GoodsAttrValueMapper goodsAttrValueMapper;
    private final GoodsAttrCateMapper goodsAttrCateMapper;

    public GoodsServiceImpl(GoodsMapper goodsMapper, GoodsPicsMapper goodsPicsMapper, GoodsDescMapper goodsDescMapper, GoodsSkuMapper goodsSkuMapper, GoodsCateMapper goodsCateMapper, GoodsAttrMapper goodsAttrMapper, GoodsAttrValueMapper goodsAttrValueMapper, GoodsAttrCateMapper goodsAttrCateMapper) {
        this.goodsMapper = goodsMapper;
        this.goodsPicsMapper = goodsPicsMapper;
        this.goodsDescMapper = goodsDescMapper;
        this.goodsSkuMapper = goodsSkuMapper;
        this.goodsCateMapper = goodsCateMapper;
        this.goodsAttrMapper = goodsAttrMapper;
        this.goodsAttrValueMapper = goodsAttrValueMapper;
        this.goodsAttrCateMapper = goodsAttrCateMapper;
    }


    @Override
    @Transactional(rollbackFor = OperationalException.class)
    public ApiResult addGoods(GoodsAddForm goodsAddForm) {
        GoodsAddDto goodsAddDto = goodsAddForm.getGoodsBasisInfo();
        GoodsDescAddDto goodsDescAddDto = goodsAddForm.getGoodsDescInfo();
        List<String> mainPicList = goodsAddForm.getMainPicList();
        List<GoodsSkuAddDto> skuList = goodsAddForm.getSkuList();
        List<GoodsAttrValueAddDto> attrValueAddDtoList = goodsAddForm.getAttrList();

        // 添加商品主表数据
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsAddDto,goods);
        goodsMapper.insert(goods);

        // 添加 商品详情表数据
        GoodsDesc goodsDesc = new GoodsDesc();
        BeanUtils.copyProperties(goodsDescAddDto,goodsDesc);
        goodsDesc.setGoodsId(goods.getId());
        goodsDescMapper.insert(goodsDesc);

        // 添加 商品主图表数据
        // 这里有待调整 MyBatis-Plus service层有saveBatch，如果一次插入多条，需要封装一个 公用service
        for (String item : mainPicList) {
            GoodsPics goodsPics = new GoodsPics();
            goodsPics.setGoodsId(goods.getId());
            goodsPics.setUrl(item);
            goodsPics.setIsDel(0);
            System.out.println(goodsPics);
            goodsPicsMapper.insert(goodsPics);
        }

        // 添加商品sku表数据
        for (GoodsSkuAddDto dto : skuList) {
            GoodsSku goodsSku = new GoodsSku();
            BeanUtils.copyProperties(dto,goodsSku);
            goodsSku.setGoodsId(goods.getId());
            goodsSkuMapper.insert(goodsSku);
        }

        // 添加商品属性值表数据
        long attrId = attrValueAddDtoList.get(0).getGoodsAttrId();
        for (GoodsAttrValueAddDto dto : attrValueAddDtoList) {
            GoodsAttr goodsAttr = goodsAttrMapper.selectById(attrId);
            if(goodsAttr == null) { throw new OperationalException("商品属性不存在"); }
            GoodsAttrValue goodsAttrValue = new GoodsAttrValue();
            BeanUtils.copyProperties(dto,goodsAttrValue);
            goodsAttrValue.setGoodsId(goods.getId());
            goodsAttrValue.setGoodsAttrName(goodsAttr.getName());
            goodsAttrValueMapper.insert(goodsAttrValue);
        }

        // 修改商品分类下商品的个数
        GoodsCate goodsCate = goodsCateMapper.selectById(goods.getCateId());
        goodsCate.setCount(goodsCate.getCount() + 1);
        goodsCateMapper.updateById(goodsCate);


        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc());
    }

    @Override
    @Transactional(rollbackFor = OperationalException.class)
    public ApiResult editGoods(GoodsEditForm goodsEditForm) {
        GoodsEditDto goodsEditDto = goodsEditForm.getGoodsBasisInfo();
        GoodsDescEditDto goodsDescEditDto = goodsEditForm.getGoodsDescInfo();
        List<String> mainPicList = goodsEditForm.getMainPicList();
        List<GoodsSkuEditDto> skuList = goodsEditForm.getSkuList();
        List<GoodsAttrValueAddDto> attrValueAddDtoList = goodsEditForm.getAttrList();


        // 编辑商品主表数据
        Goods goods = goodsMapper.selectById(goodsEditDto.getId());
        if(goods == null) { throw new OperationalException(); }
        BeanUtils.copyProperties(goodsEditDto,goods);
        goodsMapper.updateById(goods);

        // 编辑 商品详情表数据
        GoodsDesc goodsDesc = goodsDescMapper.selectById(goodsDescEditDto.getId());
        if(goodsDesc == null) { throw new OperationalException(); }
        BeanUtils.copyProperties(goodsDescEditDto,goodsDesc);
        goodsDescMapper.updateById(goodsDesc);

        // 编辑 商品主图表数据
        goodsPicsMapper.deleteByGoodsId(goods.getId());
        for (String item : mainPicList) {
            GoodsPics goodsPics = new GoodsPics();
            goodsPics.setGoodsId(goods.getId());
            goodsPics.setUrl(item);
            goodsPics.setIsDel(0);
            goodsPicsMapper.insert(goodsPics);
        }

        // 编辑商品sku表数据
        QueryWrapper<GoodsSku> skuQueryWrapper = new QueryWrapper<>();
        skuQueryWrapper.eq("goods_id",goodsEditDto.getId());
        goodsSkuMapper.delete(skuQueryWrapper);
        for (GoodsSkuEditDto dto : skuList) {
            GoodsSku goodsSku = new GoodsSku();
            BeanUtils.copyProperties(dto,goodsSku);
            goodsSku.setGoodsId(goods.getId());
            goodsSkuMapper.insert(goodsSku);
        }

        // 处理商品属性值表数据
        QueryWrapper<GoodsAttrValue> goodsAttrValueQuery = new QueryWrapper<>();
        goodsAttrValueQuery.eq("goods_id",goods.getId());
        goodsAttrValueMapper.delete(goodsAttrValueQuery);
        long attrId = attrValueAddDtoList.get(0).getGoodsAttrId();
        GoodsAttr goodsAttr = goodsAttrMapper.selectById(attrId);
        if(goodsAttr == null) { throw new OperationalException("商品属性不存在"); }
        for (GoodsAttrValueAddDto dto : attrValueAddDtoList) {
            GoodsAttrValue goodsAttrValue = new GoodsAttrValue();
            BeanUtils.copyProperties(dto,goodsAttrValue);
            goodsAttrValue.setGoodsId(goods.getId());
            goodsAttrValue.setGoodsAttrName(goodsAttr.getName());
            goodsAttrValueMapper.insert(goodsAttrValue);
        }

        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc());
    }


//    @Override
//    public ApiResult insert(GoodsEditDto goodsEditDto) {
//        Goods goods = new Goods();
//        BeanUtils.copyProperties(goodsEditDto,goods);
//        goods.setIsDel(0);
//        int row = goodsMapper.insert(goods);
//        if(row>0) {return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
//        throw new OperationalException();
//    }

    // 在删除商品的时候 有些从表的字段未做删除操作， 会出现垃圾数据问题

    @Override
    @Transactional(rollbackFor = OperationalException.class)
    public ApiResult delete(Long id) {
        if(id == null) {throw new ArgException(); }
        Goods goods = goodsMapper.selectById(id);
        if(goods == null) { throw new OperationalException(); }

        // 修改商品分类下商品的个数
        GoodsCate goodsCate = goodsCateMapper.selectById(goods.getCateId());
        goodsCate.setCount(goodsCate.getCount() - 1);
        goodsCateMapper.updateById(goodsCate);

        int row1 = goodsMapper.deleteById(id);
        int row2 = goodsCateMapper.updateById(goodsCate);

        if(row1 >1 && row2 > 0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult update(GoodsEditDto goodsEditDto) {
        if(goodsEditDto == null) { throw new ArgException(); }
        Goods goods = goodsMapper.selectById(goodsEditDto.getId());
        if(goods == null) { throw new OperationalException(); }
        BeanUtils.copyProperties(goodsEditDto,goods);
        int row = goodsMapper.updateById(goods);
        if(row>0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult updateGoodsState(GoodsEditStateParam param) {
        Goods goods = goodsMapper.selectById(param.getId());
        if(goods == null) {throw new OperationalException(); }
        BeanUtils.copyProperties(param,goods);
        int row = goodsMapper.updateById(goods);
        if(row >0) { return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc()); }
        throw new OperationalException();
    }

    @Override
    public ApiResult selectById(Long id) {
        if(id == null) { throw new ArgException(); }
        Goods goods = goodsMapper.selectById(id);
        if(goods == null ) { throw new OperationalException("商品不存在");}
        GoodsVO goodsVO = new GoodsVO();
        BeanUtils.copyProperties(goods,goodsVO);
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(),goodsVO, true);
    }

    @Override
    public ApiResult selectByParam(GoodsSelectParam param) {
        QueryWrapper<GoodsVO> queryWrapper = new QueryWrapper<>();
        if(param.getId() != null) { queryWrapper.eq("id", param.getId()); }
        if(param.getIsHot() != null) { queryWrapper.eq("is_hot", param.getIsHot()); }
        if(param.getBrandId() != null) { queryWrapper.eq("brand_id", param.getBrandId()); }
        if(param.getCateId() != null) { queryWrapper.eq("cate_id", param.getCateId()); }
        if(param.getIsSale() != null) { queryWrapper.eq("is_sale", param.getIsSale()); }
        if(param.getIsPreSale() != null) { queryWrapper.eq("is_pre_sale", param.getIsPreSale()); }
        if(param.getVerifyStatus() != null) { queryWrapper.eq("verify_status",param.getVerifyStatus()); }
        if(!StringUtils.isBlank(param.getName())) { queryWrapper.like("name",param.getName()); }
        queryWrapper.eq("g.is_del",0).groupBy("g.id");
        IPage<GoodsVO> page = goodsMapper.selectMyPage(
            new Page<>(param.getPage(), param.getSize()),
            queryWrapper
        );
        return new ApiResult(HttpCodeEnum.SUCCESS.getCode(), HttpCodeEnum.SUCCESS.getDesc(), page);
    }

    @Override
    public ApiResult selectGoodsDetailById(Long id) {
        if(id == null) { throw new ArgException(); }
        ApiResult goodsVoResult = selectById(id);
        if(!goodsVoResult.getStatus()) { throw new OperationalException(); }
        GoodsVO goodsVO = (GoodsVO) goodsVoResult.getData();
        List<GoodsPicVO> goodsPics = goodsPicsMapper.selectPicsByGoodsId(id);
        GoodsDescVO goodsDescVO = goodsDescMapper.selectByGoodsId(id);
        List<GoodsSkuVO> goodsSkuVOList = goodsSkuMapper.selectByGoodsId(id);
        List<GoodsAttrValueVO> goodsAttrValueVOList = goodsAttrValueMapper.selectByGoodsId(goodsVO.getId());

        GoodsDetailVO goodsDetailVO = new GoodsDetailVO();
        BeanUtils.copyProperties(goodsVO,goodsDetailVO);
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
