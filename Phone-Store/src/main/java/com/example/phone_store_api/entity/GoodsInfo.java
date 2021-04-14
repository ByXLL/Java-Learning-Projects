package com.example.phone_store_api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品信息 实体
 * @author By-Lin
 */
@Data
@Entity
public class GoodsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer goodsId;
    private String goodsName;
    private BigDecimal goodsPrice;
    private String goodsDescription;
    private Integer goodsStock;
    private String goodsIcon;
    private String goodsTag;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;
}
