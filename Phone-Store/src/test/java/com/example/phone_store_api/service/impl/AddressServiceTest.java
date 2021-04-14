package com.example.phone_store_api.service.impl;

import com.example.phone_store_api.form.AddressForm;
import com.example.phone_store_api.vo.address.AddressVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceTest {
    @Autowired
    private AddressService addressService;

    @Test
    void findAll() {
        List<AddressVO> addressVOList = addressService.findAll();
        System.out.println("");
    }

    @Test
    void saveOrUpdate() {
        AddressForm addressForm = new AddressForm();
        addressForm.setId(35);
        addressForm.setName("狗哥");
        addressForm.setTel("13911111111");
        addressForm.setProvince("广东省");
        addressForm.setCity("深圳市");
        addressForm.setCounty("罗湖区");
        addressForm.setAddressDetail("香蜜湖");
        addressForm.setAreaCode("0716");
        addressService.saveOrUpdate(addressForm);
    }
}