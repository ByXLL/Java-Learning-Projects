package com.example.mall.utils;


import com.example.mall.vo.GoodsCateTreeVO;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类 创建分类树 工具类
 * @author By-Lin
 */
public class GoodsCateUtils {
    /**
     * 方法一 递归
     * @param goodsCateTreeVOList       商品分类 数组
     * @return                      商品分类 数组
     */
    @Deprecated
    public static List<GoodsCateTreeVO> buildTree1(List<GoodsCateTreeVO> goodsCateTreeVOList) {
        List<GoodsCateTreeVO> result = new ArrayList<>();
        for (GoodsCateTreeVO item:goodsCateTreeVOList) {
            if (item.getCatePid() == 0) {
                result.add(item);
                setChildren(goodsCateTreeVOList, item);
            }
        }
        return result;
    }

    private static void setChildren(List<GoodsCateTreeVO> list, GoodsCateTreeVO parent) {
        for (GoodsCateTreeVO item: list) {
            if(parent.getCateId().equals(item.getCatePid())){
                parent.getChildren().add(item);
            }
        }
        if (parent.getChildren().isEmpty()) {
            return;
        }
        for (GoodsCateTreeVO item: parent.getChildren()) {
            setChildren(list, item);
        }
    }


    /**
     * 方法二 递归 创建树
     * @param goodsCateTreeVOList       商品分类 数组
     * @return
     */
    public static List<GoodsCateTreeVO> buildTree2(List<GoodsCateTreeVO> goodsCateTreeVOList) {
        List<GoodsCateTreeVO> result = new ArrayList<>();
        for (GoodsCateTreeVO item : goodsCateTreeVOList) {
            if (item.getCatePid() == 0) {
                result.add(item);
            }
            for (GoodsCateTreeVO child : goodsCateTreeVOList) {
                if (child.getCatePid().equals(item.getCateId())) {
                    item.addChildren(child);
                }
            }
        }
        return result;
    }


//    public static List<GoodsCateTreeVO> buildTree3(List<GoodsCateTreeVO> goodsCateTreeVOList) {
//        Map<String, List<GoodsCateTreeVO>> zoneByParentIdMap = goodsCateTreeVOList.stream().
//                                                                collect(Collectors.groupingBy(GoodsCateTreeVO::getCatePid());
//        zoneList.forEach(zone->zone.children = zoneByParentIdMap.get(zone.id));
//        return zoneList.stream().filter(v -> v.parentId.equals("0")).collect(Collectors.toList());
//
//    }
}
