package com.example.phone_store_api.repository;

import com.example.phone_store_api.entity.BuyerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户收货地址的 Repository 接口
 * 继承自 JpaRepository 第一个参数是 实体  第二个是主键的数据类型
 * @author By-Lin
 */
public interface BuyerAddressRepository extends JpaRepository<BuyerAddress,Integer> {
}
