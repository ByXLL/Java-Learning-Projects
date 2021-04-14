package com.example.phone_store_api.service.impl;

import com.example.phone_store_api.entity.BuyerAddress;
import com.example.phone_store_api.form.AddressForm;
import com.example.phone_store_api.repository.BuyerAddressRepository;
import com.example.phone_store_api.service.AddressServiceInterface;
import com.example.phone_store_api.vo.address.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户地址 service 接口实现类
 * @author By-Lin
 */
@Service
public class AddressService implements AddressServiceInterface {
    private final BuyerAddressRepository buyerAddressRepository;

    public AddressService(BuyerAddressRepository buyerAddressRepository) {
        this.buyerAddressRepository = buyerAddressRepository;
    }

    @Override
    public List<AddressVO> findAll() {
        List<AddressVO> addressVOList = buyerAddressRepository.findAll().stream().map(item -> new AddressVO(
                            item.getAddressId(),
                            item.getAreaCode(),
                            item.getBuyerName(),
                            item.getBuyerPhone(),
                            item.getBuyerAddress()
                        )).collect(Collectors.toList());

        return addressVOList;
    }

    @Override
    public void saveOrUpdate(@Valid AddressForm addressForm) {
        BuyerAddress buyerAddress;
        if(addressForm.getId() == null) {
            buyerAddress = new BuyerAddress();
        }else {
            buyerAddress = buyerAddressRepository.findById(addressForm.getId()).orElse(null);
            if(buyerAddress == null) { throw new IllegalArgumentException("用户地址不存在"); }
        }
        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        String address = addressForm.getProvince() +
                addressForm.getCity() +
                addressForm.getCounty() +
                addressForm.getAddressDetail();
        buyerAddress.setBuyerAddress(address);
        buyerAddress.setAreaCode(addressForm.getAreaCode());
        buyerAddressRepository.save(buyerAddress);
    }
}
