package com.example.phone_store_api.repository;

import com.example.phone_store_api.entity.GoodsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品信息的 Repository 接口
 * 继承自 JpaRepository 第一个参数是 实体  第二个是主键的数据类型
 * @author By-Lin
 */
public interface GoodsInfoRepository extends JpaRepository<GoodsInfo,Integer> {
    /**
     * 通过商品分类 获取商品集合
     * @param categoryType      商品分类
     * @return                  商品集合
     */
    List<GoodsInfo> findByCategoryType(Integer categoryType);
}
