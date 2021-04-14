package com.example.phone_store_api.vo.goodscategory;

import com.example.phone_store_api.vo.goodsspecs.GoodsSpecsVO;
import lombok.Data;

import java.util.List;

/**
 * SpecsPackageVO -> Tree
 * @author By-Lin
 */
@Data
public class TreeVO {
    private String k = "规格";
    private List<GoodsSpecsVO> v;
    private String k_s = "s1";
}
