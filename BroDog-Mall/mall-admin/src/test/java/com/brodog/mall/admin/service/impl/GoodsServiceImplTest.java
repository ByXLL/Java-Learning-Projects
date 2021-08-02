package com.brodog.mall.admin.service.impl;

import com.brodog.mall.admin.form.goods.GoodsSelectParam;
import com.brodog.mall.common.entity.ApiResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GoodsServiceImplTest {
    @Autowired
    private GoodsServiceImpl service;

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void selectById() {
    }

    @Test
    void selectByParam() {
        GoodsSelectParam param = new GoodsSelectParam();
//        param.setId(1L);
//        param.setBrandId(1L);
        param.setName("华为1111");
        param.setPage(1);
        param.setSize(1);
        ApiResult result = service.selectByParam(param);
        System.out.println();
    }

    @Test
    void selectGoodsDetailById() {
        ApiResult result = service.selectGoodsDetailById(1399004981104087042L);
        System.out.println();
    }
}