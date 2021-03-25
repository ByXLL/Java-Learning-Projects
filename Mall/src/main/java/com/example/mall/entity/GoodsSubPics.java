package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品小图实体
 * @author By-Lin
 */
@Data
public class GoodsSubPics {
    private Integer id;
    private Integer goodsId;
    private String url;
}
