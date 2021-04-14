package com.example.phone_store_api.service;

import com.example.phone_store_api.form.AddressForm;
import com.example.phone_store_api.vo.address.AddressVO;

import java.util.List;

/**
 * 用户地址 service 接口
 * @author By-Lin
 */
public interface AddressServiceInterface {
    /**
     * 查询所有地址
     * @return      地址 vo list
     */
    List<AddressVO> findAll();

    /**
     * 更新或者添加 地震
     * @param addressForm       地址信息表单数据
     */
    void saveOrUpdate(AddressForm addressForm);
}
