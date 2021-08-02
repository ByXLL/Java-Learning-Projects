package com.brodog.mall.app.service.impl;

import com.brodog.mall.app.form.goods.GoodsSelectParam;
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
        GoodsSelectParam param = new GoodsSelectParam();
        param.setName("手机");
//        param.setBrandId();
//        param.setCateId();
//        param.setMinPrice();
//        param.setMaxPrice();
//        param.setSortBy();
//        param.setPage();
//        param.setSize();


    }

    @Test
    void selectById() {
        ApiResult result = goodsService.selectById(1399004981104087042L);
        System.out.println("111");
    }

    @Test
    void testBingfa() throws Exception {
        for (int i = 1; i < 20; i++) {
            System.out.printf("%s+++++++%n",i);
            if(i > 10) {
                throw new Exception("操作失败");
            }
        }
        System.out.println("------------");
    }
}