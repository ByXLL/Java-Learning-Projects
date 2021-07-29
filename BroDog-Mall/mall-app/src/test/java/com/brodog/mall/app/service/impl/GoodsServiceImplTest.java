package com.brodog.mall.app.service.impl;

import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.common.entity.PagerParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GoodsServiceImplTest {
    @Autowired
    private GoodsServiceImpl goodsService;

    @Test
    void selectHotList() {
        ApiResult result = goodsService.selectHotList(new PagerParam(1, 10));
        System.out.println("1111");
    }

    @Test
    void selectByParam() {
    }

    @Test
    void selectById() {
    }
}