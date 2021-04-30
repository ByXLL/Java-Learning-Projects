package com.brodog.mall.admin.service.impl;

import com.brodog.mall.common.entity.ApiResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsSpecServiceImplTest {
    @Autowired
    private GoodsSpecServiceImpl goodsSpecService;

    @Test
    void selectByPage() {
    }

    @Test
    void selectById() {
        ApiResult result = goodsSpecService.selectById(1L);
        System.out.println();
    }
}