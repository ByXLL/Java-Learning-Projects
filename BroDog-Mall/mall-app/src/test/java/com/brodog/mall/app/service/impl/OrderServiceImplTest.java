package com.brodog.mall.app.service.impl;
import com.brodog.mall.app.dto.order.OrderGoodsAddDto;
import com.brodog.mall.common.entity.ApiResult;
import com.brodog.mall.app.form.order.OrderAddForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    void testMultiply() {
        BigDecimal price = new BigDecimal("100.50");

        BigDecimal total = price.multiply(new BigDecimal(2));
        System.out.println(total);
    }

    @Test
    void testAddOrder() {
        OrderAddForm orderAddForm = new OrderAddForm();
        orderAddForm.setSourceType(1);
        orderAddForm.setOrderType(0);
        orderAddForm.setPayType(1);
        orderAddForm.setUserId(1L);
        orderAddForm.setReceiverName("张三");
        orderAddForm.setReceiverPhone("13911111111");
        orderAddForm.setReceiverPostCode("54500");
        orderAddForm.setReceiverProvince("广西省");
        orderAddForm.setReceiverCity("南宁市");
        orderAddForm.setReceiverRegion("青秀区");
        orderAddForm.setReceiverDetailAddress("广西南宁市青秀区麻村二街");
        List<OrderGoodsAddDto> orderGoodsList = new ArrayList<>();

//        OrderGoodsAddDto orderGoods1 = new OrderGoodsAddDto();
//        orderGoods1.setGoodsId(1399004981104087042L);
//        orderGoods1.setCount(2);
//        orderGoods1.setGoodsPic("//m.360buyimg.com/mobilecms/s750x750_jfs/t1/170594/22/11087/77947/6046dbefE3dcac89f/9caaf77c0a4f0976.jpg!q80.dpg.webp");
//        orderGoods1.setSkuId(1399004984727965697L);
//        orderGoods1.setSkuNumber("B-001");
//        orderGoods1.setSkuData("[{\"key\":\"颜色\",\"value\":\"亮黑色\"},{\"key\":\"容量\",\"value\":\"128G\"}]");
//        orderGoods1.setPromotionName("");

        OrderGoodsAddDto orderGoods2 = new OrderGoodsAddDto();
        orderGoods2.setGoodsId(1399184297293152257L);
        orderGoods2.setCount(1);
        orderGoods2.setGoodsPic("//img14.360buyimg.com/n4/jfs/t1/186013/22/3604/163539/609b77e6Ea82802e1/7caa8f197682d1c3.jpg");
        orderGoods2.setSkuId(1399184297481895939L);
        orderGoods2.setSkuNumber("O-Q-8T-8-256");
        orderGoods2.setSkuData("[{\"key\":\"颜色\",\"value\":\"青域\"},{\"key\":\"容量\",\"value\":\"8+256g\"}]");
        orderGoods2.setPromotionName("");

//        orderGoodsList.add(orderGoods1);
        orderGoodsList.add(orderGoods2);


        orderAddForm.setOrderGoodsList(orderGoodsList);

        ApiResult result = orderService.addOrder(orderAddForm);
        System.out.println(result);

    }
}