package com.example.phone_store_api.repository;

import com.example.phone_store_api.entity.GoodsCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsCategoryRepositoryTest {
    @Autowired
    private GoodsCategoryRepository repository;

    @Test
    void findAll() {
        List<GoodsCategory> list = repository.findAll();
        for (GoodsCategory goodsCategory : list) {
            System.out.println(goodsCategory);
        }
    }

    @Test
    void findByCategoryType() {
        GoodsCategory goodsCategory = repository.findByCategoryType(1);
        System.out.println(goodsCategory);
    }
}