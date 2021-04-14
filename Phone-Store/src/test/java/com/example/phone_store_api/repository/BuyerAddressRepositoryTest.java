package com.example.phone_store_api.repository;

import com.example.phone_store_api.entity.BuyerAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuyerAddressRepositoryTest {
    @Autowired
    private BuyerAddressRepository repository;

    @Test
    void findAll() {
        List<BuyerAddress> buyerAddresses = repository.findAll();
        for (BuyerAddress buyerAddress : buyerAddresses) {
            System.out.println(buyerAddress);
        }
    }
    @Test
    void save() {
        BuyerAddress buyerAddress = new BuyerAddress();
        buyerAddress.setBuyerName("张三");
        buyerAddress.setBuyerPhone("13977777777");
        buyerAddress.setBuyerAddress("广西壮族自治区青秀区朝阳广场");
        buyerAddress.setAreaCode("0775-0101");
        repository.save(buyerAddress);
    }

    @Test
    void update() {
        BuyerAddress buyerAddress = repository.findById(35).get();
        buyerAddress.setAreaCode("0775");
        repository.save(buyerAddress);
    }
}