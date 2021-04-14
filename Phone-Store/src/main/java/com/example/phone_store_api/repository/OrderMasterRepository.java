package com.example.phone_store_api.repository;

import com.example.phone_store_api.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单的 Repository 接口
 * 继承自 JpaRepository 第一个参数是 实体  第二个是主键的数据类型
 * @author By-Lin
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

}
