package com.example.phone_store_api.repository;

import com.example.phone_store_api.entity.GoodsSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品规格的 Repository 接口
 * 继承自 JpaRepository 第一个参数是 实体  第二个是主键的数据类型
 * @author By-Lin
 */
public interface GoodsSpecsRepository extends JpaRepository<GoodsSpecs,Integer> {
    /**
     * 通过 商品id 获取 商品所有规格
     * @param goodsId       商品id
     * @return              商品规格集合
     */
    List<GoodsSpecs> findAllByGoodsId(Integer goodsId);
}
