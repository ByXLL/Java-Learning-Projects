package com.example.mall.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类 树 vo
 * @author By-Lin
 */
@Data
public class GoodsCateTreeVO extends GoodsCateVO {
    private List<GoodsCateTreeVO> children;


    public GoodsCateTreeVO(Integer cateId, String cateName, Integer catePid) {
        super.setCateId(cateId);
        super.setCateName(cateName);
        super.setCatePid(catePid);
    }

    public void addChildren(GoodsCateTreeVO goodsCateTreeVO) {
        if(children == null) {
            children = new ArrayList<>();
        }
        children.add(goodsCateTreeVO);
    }
}
