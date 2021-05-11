package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.*;
import com.brodog.mall.admin.service.impl.GoodsAttrServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsCate;
import com.brodog.mall.common.entity.GoodsPics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GoodsAttrServiceTest {
    @Autowired
    private GoodsAttrServiceImpl goodsAttrService;

    @Test
    void insert() {
        GoodsAttrAddDto goodsAttrAddDto = new GoodsAttrAddDto();
        goodsAttrAddDto.setName("test");
        goodsAttrAddDto.setSpecCount(100);
        goodsAttrAddDto.setAttrCount(100);
        goodsAttrAddDto.setIsDel(0);
        ApiResult row = goodsAttrService.insert(goodsAttrAddDto);
        System.out.println();
    }

    @Test
    void selectAll() {
        ApiResult goodsAttrList = goodsAttrService.selectAll();

        System.out.println();
    }

    @Test
    void copyBean() {
        GoodsPics goodsPics = new GoodsPics();
        goodsPics.setId(1L);
        goodsPics.setGoodsId(1L);
        goodsPics.setUrl("www.baidu.com");
        goodsPics.setIsDel(0);

        GoodsPicsEditDto goodsPicsEditDto = new GoodsPicsEditDto();
        goodsPicsEditDto.setGoodsId(1L);
        goodsPicsEditDto.setId(1L);
//        goodsPicsEditDto.setUrl("");

        BeanUtils.copyProperties(goodsPicsEditDto, goodsPics);

        System.out.println();
    }
}