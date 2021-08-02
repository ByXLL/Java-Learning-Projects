package com.brodog.mall.app.service.impl;

import com.brodog.mall.app.form.goodsComment.GoodsCommentSelectParam;
import com.brodog.mall.common.entity.ApiResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsCommentServiceImplTest {
    @Autowired
    private GoodsCommentServiceImpl goodsCommentService;
    @Test
    void addGoodsComment() {

    }

    @Test
    void selectListByParam() {
        GoodsCommentSelectParam param = new GoodsCommentSelectParam();
        param.setGoodsId(1399004981104087042L);
        param.setGrade(1);
        param.setPage(1);
        param.setSize(10);

        ApiResult result = goodsCommentService.selectListByParam(param);
        System.out.println("1111");
    }
}