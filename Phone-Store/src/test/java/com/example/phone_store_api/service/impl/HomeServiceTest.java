package com.example.phone_store_api.service.impl;

import com.example.phone_store_api.vo.home.HomeVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HomeServiceTest {
    @Autowired
    private HomeService homeService;
    @Test
    void findData() {
        HomeVO homeVO = homeService.findData();
    }
}