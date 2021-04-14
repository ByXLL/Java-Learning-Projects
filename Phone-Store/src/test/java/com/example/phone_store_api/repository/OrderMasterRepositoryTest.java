package com.example.phone_store_api.repository;

import com.example.phone_store_api.entity.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;


@SpringBootTest
class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    @Test
    void findAll() {
        List<OrderMaster> orderMasters = repository.findAll();
        for (OrderMaster orderMaster : orderMasters) {
            System.out.println(orderMaster);
        }
    }

    @Test
    void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("dadagsrrfe");
        orderMaster.setBuyerName("张三");
        orderMaster.setBuyerPhone("13977777777");
        orderMaster.setBuyerAddress("广西壮族自治区青秀区朝阳广场");
        orderMaster.setOrderAmount(new BigDecimal(6400));
        orderMaster.setPayStatus(0);
        orderMaster.setGoodsIcon("www.baidu.com");
        orderMaster.setGoodsId(1);
        orderMaster.setGoodsName("Honor 8A");
        orderMaster.setGoodsQuantity(2);
        orderMaster.setSpecsId(1);
        orderMaster.setSpecsName("32GB");
        orderMaster.setSpecsPrice(new BigDecimal(320000));
        repository.save(orderMaster);
    }

    @Test
    void findById() {
        OrderMaster orderMaster = repository.findById("dadagsrrfe").get();
        System.out.println(orderMaster);
    }
    @Test
    void  pay() {
        OrderMaster orderMaster = repository.findById("dadagsrrfe").get();
        orderMaster.setPayStatus(1);
        repository.save(orderMaster);
    }
}