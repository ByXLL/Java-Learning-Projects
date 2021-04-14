package com.example.phone_store_api.repository;

import com.example.phone_store_api.entity.GoodsSpecs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsSpecsRepositoryTest {
    @Autowired
    private GoodsSpecsRepository repository;

    @Test
    void findAll() {
        List<GoodsSpecs> goodsSpecs = repository.findAll();
        for (GoodsSpecs goodsSpec : goodsSpecs) {
            System.out.println(goodsSpec);
        }
    }

}