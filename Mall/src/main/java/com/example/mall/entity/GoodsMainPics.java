package com.example.mall.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品主图实体
 * @author By-Lin
 */
@Data
public class GoodsMainPics {
    private Integer id;
    private Integer goodsId;
    private String url;
}
