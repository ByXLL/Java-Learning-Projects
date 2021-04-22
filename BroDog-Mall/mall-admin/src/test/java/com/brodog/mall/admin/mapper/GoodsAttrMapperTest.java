package com.brodog.mall.admin.mapper;

import com.brodog.mall.common.entity.GoodsAttr;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsAttrMapperTest {
    @Autowired
    private GoodsAttrMapper goodsAttrMapper;

    @Test
    void findAll() {
        List<GoodsAttr> goodsAttrList = goodsAttrMapper.selectList(null);
        System.out.println();
    }

    @Test
    void insert() {
        GoodsAttr goodsAttr = new GoodsAttr();
        goodsAttr.setName("test");
        goodsAttr.setSpecCount(100);
        goodsAttr.setSpecCount(100);
        goodsAttr.setIsDel(0);

        int row = goodsAttrMapper.insert(goodsAttr);
        System.out.println();
    }
}