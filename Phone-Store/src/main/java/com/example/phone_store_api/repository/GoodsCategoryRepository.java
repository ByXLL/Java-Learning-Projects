package com.example.phone_store_api.repository;

import com.example.phone_store_api.entity.GoodsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品分类的 Repository 接口
 * 继承自 JpaRepository 第一个参数是 实体  第二个是主键的数据类型
 * @author By-Lin
 */
public interface GoodsCategoryRepository extends JpaRepository<GoodsCategory,Integer>{
    /***
     * 在jpa 里面只会生成通用性的方法 如果需要自定义 操作方法 可以在这里编写
     */

    /**
     * 根据 分类编号 查询商品分类
     * @param categoryType      分类编号
     * @return                  商品分类实体
     */
    GoodsCategory findByCategoryType(Integer categoryType);

}
