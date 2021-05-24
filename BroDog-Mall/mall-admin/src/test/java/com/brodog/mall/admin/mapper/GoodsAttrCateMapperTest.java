package com.brodog.mall.admin.mapper;

import com.brodog.mall.common.entity.GoodsAttrCate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GoodsAttrCateMapperTest {
    @Autowired
    private GoodsAttrCateMapper goodsAttrCateMapper;

    @Test
    void findAll() {
        List<GoodsAttrCate> goodsAttrCateList = goodsAttrCateMapper.selectList(null);
        System.out.println();
    }

    @Test
    void insert() {
        GoodsAttrCate goodsAttrCate = new GoodsAttrCate();
        goodsAttrCate.setName("test");
        goodsAttrCate.setSpecCount(100);
        goodsAttrCate.setSpecCount(100);
        goodsAttrCate.setIsDel(0);

        int row = goodsAttrCateMapper.insert(goodsAttrCate);
        System.out.println();
    }
}