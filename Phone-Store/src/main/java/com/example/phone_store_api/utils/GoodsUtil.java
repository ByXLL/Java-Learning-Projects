package com.example.phone_store_api.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品 模块 工具类
 * @author By-Lin
 */
public class GoodsUtil {

    /**
     * 商品 tag 字符串 转对象数组
     * @param tag       tag 字符串
     * @return          tag 对象数组
     */
    public static List<Map<String,Object>> getTagArray(String tag) {
        List<Map<String,Object>> list = new ArrayList<>();
        String[] tags = tag.split("&");
        Map<String,Object> map;
        for (String s : tags) {
            map = new HashMap<>(16);
            map.put("name",s);
            list.add(map);
        }
        return list;
    }
}
