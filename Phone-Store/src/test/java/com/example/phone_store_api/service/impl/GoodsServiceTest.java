package com.example.phone_store_api.service.impl;

import com.example.phone_store_api.vo.goodsinfo.GoodsInfoVO;
import com.example.phone_store_api.vo.goodsspecs.SpecsPackageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsServiceTest {
    @Autowired
    private GoodsService goodsService;

    @Test
    void findGoodsInfoByCategoryType() {
        List<GoodsInfoVO> goodsInfoVOList = goodsService.findGoodsInfoByCategoryType(2);
        System.out.println("");
    }

    @Test
    void findSku() {
        SpecsPackageVO specsPackageVO = goodsService.findSpecsByGoodsId(1);
        System.out.println("");
    }

    @Test
    void subStock() {
        goodsService.subStock(1,2);
    }
}