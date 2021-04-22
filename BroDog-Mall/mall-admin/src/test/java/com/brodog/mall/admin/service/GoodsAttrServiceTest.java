package com.brodog.mall.admin.service;

import com.brodog.mall.admin.dto.goods.GoodsAttrDto;
import com.brodog.mall.admin.mapper.GoodsAttrMapper;
import com.brodog.mall.admin.mapper.GoodsBrandMapper;
import com.brodog.mall.admin.service.impl.GoodsAttrServiceImpl;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.GoodsAttr;
import com.brodog.mall.common.entity.GoodsBrand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GoodsAttrServiceTest {
    @Autowired
    private GoodsAttrServiceImpl goodsAttrService;

    @Test
    void insert() {
        GoodsAttrDto goodsAttrDto = new GoodsAttrDto();
        goodsAttrDto.setName("test");
        goodsAttrDto.setSpecCount(100);
        goodsAttrDto.setAttrCount(100);
        goodsAttrDto.setIsDel(0);
        ApiResult row = goodsAttrService.insert(goodsAttrDto);
        System.out.println();
    }

    @Test
    void selectAll() {
        ApiResult goodsAttrList = goodsAttrService.selectAll();

        System.out.println();
    }

}