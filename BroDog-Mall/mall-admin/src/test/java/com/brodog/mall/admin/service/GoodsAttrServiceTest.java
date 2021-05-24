package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.*;
import com.brodog.mall.admin.service.impl.GoodsAttrCateServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsPics;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GoodsAttrServiceTest {
    @Autowired
    private GoodsAttrCateServiceImpl goodsAttrService;

    @Test
    void insert() {
        GoodsAttrCateAddDto goodsAttrCateAddDto = new GoodsAttrCateAddDto();
        goodsAttrCateAddDto.setName("test");
        goodsAttrCateAddDto.setSpecCount(100);
        goodsAttrCateAddDto.setAttrCount(100);
        goodsAttrCateAddDto.setIsDel(0);
        ApiResult row = goodsAttrService.insert(goodsAttrCateAddDto);
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