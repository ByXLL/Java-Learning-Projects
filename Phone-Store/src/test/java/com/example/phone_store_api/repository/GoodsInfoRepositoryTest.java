package com.example.phone_store_api.repository;

import com.example.phone_store_api.entity.GoodsInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsInfoRepositoryTest {
    @Autowired
    private GoodsInfoRepository repository;

    @Test
    void findAll() {
        List<GoodsInfo> goodsInfos = repository.findAll();
        for (GoodsInfo goodsInfo : goodsInfos) {
            System.out.println(goodsInfo);
        }
    }

    @Test
    void findByCategoryType() {
        List<GoodsInfo> goodsInfos = repository.findByCategoryType(1);
        for (GoodsInfo goodsInfo : goodsInfos) {
            System.out.println(goodsInfo);
        }
    }
}