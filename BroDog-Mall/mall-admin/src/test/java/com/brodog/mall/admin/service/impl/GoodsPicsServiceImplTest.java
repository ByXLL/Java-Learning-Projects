package com.brodog.mall.admin.service.impl;

import com.brodog.mall.admin.mapper.GoodsPicsMapper;
import com.brodog.mall.admin.vo.goods.GoodsPicVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsPicsServiceImplTest {
    @Autowired
    private GoodsPicsMapper mapper;

    @Test
    void selectByGoodsId() {
        List<GoodsPicVO> urlList = mapper.selectPicsByGoodsId(1L);
        System.out.println();
    }
}