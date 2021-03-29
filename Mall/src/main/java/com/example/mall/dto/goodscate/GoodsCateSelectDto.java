package com.example.mall.dto.goodscate;

import lombok.Data;

/**
 * 商品分类 查询 dto
 * @author By-Lin
 */
@Data
public class GoodsCateSelectDto {
    private Integer cateId;

    private String cateName;

    private Integer catePid;
}
