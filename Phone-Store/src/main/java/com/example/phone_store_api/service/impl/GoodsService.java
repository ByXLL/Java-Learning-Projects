package com.example.phone_store_api.service.impl;

import com.example.phone_store_api.entity.GoodsInfo;
import com.example.phone_store_api.entity.GoodsSpecs;
import com.example.phone_store_api.enums.ResultEnum;
import com.example.phone_store_api.exception.GlobalException;
import com.example.phone_store_api.repository.GoodsInfoRepository;
import com.example.phone_store_api.repository.GoodsSpecsRepository;
import com.example.phone_store_api.service.GoodsServiceInterface;
import com.example.phone_store_api.utils.GoodsUtil;
import com.example.phone_store_api.vo.goodscategory.TreeVO;
import com.example.phone_store_api.vo.goodsinfo.GoodsInfoVO;
import com.example.phone_store_api.vo.goodsspecs.GoodsSpecsCasVO;
import com.example.phone_store_api.vo.goodsspecs.GoodsSpecsVO;
import com.example.phone_store_api.vo.goodsspecs.SpecsPackageVO;
import com.example.phone_store_api.vo.sku.SkuVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品 service 接口实现类
 * @author By-Lin
 */
@Service
@Slf4j
public class GoodsService implements GoodsServiceInterface {
    private final GoodsSpecsRepository goodsSpecsRepository;
    private final GoodsInfoRepository goodsInfoRepository;

    public GoodsService(GoodsSpecsRepository goodsSpecsRepository, GoodsInfoRepository goodsInfoRepository) {
        this.goodsSpecsRepository = goodsSpecsRepository;
        this.goodsInfoRepository = goodsInfoRepository;
    }

    @Override
    public List<GoodsInfoVO> findGoodsInfoByCategoryType(Integer categoryId) {
        List<GoodsInfo> goodsInfoList = goodsInfoRepository.findByCategoryType(categoryId);

        List<GoodsInfoVO> goodsInfoVOList = goodsInfoList.stream().map(item -> new GoodsInfoVO(
                item.getGoodsId(),
                item.getGoodsName(),
                item.getGoodsPrice()+".00",
                item.getGoodsDescription(),
                GoodsUtil.getTagArray(item.getGoodsTag()),
                item.getGoodsIcon()
        )).collect(Collectors.toList());

        return goodsInfoVOList;
    }

    @Override
    public SpecsPackageVO findSpecsByGoodsId(Integer goodsId) {
        GoodsInfo goodsInfo = goodsInfoRepository.findById(goodsId).orElse(null);
        if(goodsInfo == null) { throw new GlobalException(ResultEnum.GOODS_NULL_ERROR); }
        // 商品规格 列表
        List<GoodsSpecs> goodsSpecsList = goodsSpecsRepository.findAllByGoodsId(goodsInfo.getGoodsId());

        // sku -> tree ->

        List<GoodsSpecsVO> goodsSpecsVOList = new ArrayList<>();
        // sku -> list ->
        List<GoodsSpecsCasVO> goodsSpecsCasVOList = new ArrayList<>();

        GoodsSpecsVO goodsSpecsVO;
        GoodsSpecsCasVO goodsSpecsCasVO;

        for (GoodsSpecs goodsSpecs : goodsSpecsList) {
            goodsSpecsVO = new GoodsSpecsVO();
            goodsSpecsCasVO = new GoodsSpecsCasVO();
            // 拿到 GoodsSpecsVO  即 tree -> item.v ->
            BeanUtils.copyProperties(goodsSpecs,goodsSpecsVO);
            // 拿到 GoodsSpecsVO  即 sku -> list
            BeanUtils.copyProperties(goodsSpecs,goodsSpecsCasVO);

            goodsSpecsVOList.add(goodsSpecsVO);
            goodsSpecsCasVOList.add(goodsSpecsCasVO);
        }
        // 设置 tree.v
        TreeVO treeVO = new TreeVO();
        treeVO.setV(goodsSpecsVOList);

        // 构建 tree list
        List<TreeVO> treeVOList = new ArrayList<>();
        treeVOList.add(treeVO);

        // 将价格转为 Integer
        Integer price = goodsInfo.getGoodsPrice().intValue();


        // 构建 sku
        SkuVO skuVO = new SkuVO();
        skuVO.setTree(treeVOList);
        skuVO.setPrice(price+".00");
        skuVO.setStockNum(goodsInfo.getGoodsStock());
        skuVO.setList(goodsSpecsCasVOList);

        // 构建 SpecsPackageVO
        SpecsPackageVO specsPackageVO = new SpecsPackageVO();
        specsPackageVO.setSku(skuVO);
        Map<String,Object> goods = new HashMap<>(16);
        goods.put("picture",goodsInfo.getGoodsIcon());
        specsPackageVO.setGoods(goods);

        return specsPackageVO;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void subStock(Integer specsId, Integer quantity) {
        // 先根据 规格id 拿到当前规格的库存
        GoodsSpecs goodsSpecs = goodsSpecsRepository.findById(specsId).orElse(null);
        if(goodsSpecs == null) { throw new GlobalException(ResultEnum.GOODS_SPECS_NULL_ERROR); }

        // 拿到商品表中的商品信息
        GoodsInfo goodsInfo = goodsInfoRepository.findById(goodsSpecs.getGoodsId()).orElse(null);
        if(goodsInfo == null) { throw new GlobalException(ResultEnum.STOCK_ERROR); }

        // 修改 规格的库存
        int result = goodsSpecs.getSpecsStock() - quantity;
        if(result < 0) {
            log.error("【扣库存】 库存不足");
            throw new GlobalException(ResultEnum.STOCK_ERROR);
        }
        goodsSpecs.setSpecsStock(result);
        goodsSpecsRepository.save(goodsSpecs);

        // 修改 商品的总库存
        result = goodsInfo.getGoodsStock() - quantity;
        if(result < 0) {
            log.error("【扣库存】 库存不足");
            throw new GlobalException(ResultEnum.STOCK_ERROR);
        }
        goodsInfo.setGoodsStock(result);
        goodsInfoRepository.save(goodsInfo);

    }
}
