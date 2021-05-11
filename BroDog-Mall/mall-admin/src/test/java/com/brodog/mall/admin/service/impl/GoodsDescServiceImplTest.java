package com.brodog.mall.admin.service.impl;

import com.brodog.mall.common.entity.ApiResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsDescServiceImplTest {
    @Autowired
    private GoodsDescServiceImpl service;

    @Test
    void selectByGoodsId() {
        ApiResult apiResult = service.selectByGoodsId(1L);
        System.out.println();
    }
}