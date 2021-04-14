package com.example.phone_store_api.utils;

import java.util.Random;

/**
 * 公共 工具类
 * @author By-Lin
 */
public class CommUtils {
    /**
     * 生成一个随机数
     * @return      随机数字符串
     */
    public static synchronized String createUniqueKey() {
        Random random = new Random();
        // 生成一个6位随机数
        Integer key = random.nextInt(900000) + 100000;
        // 系统时间毫秒数 + 随机数
        return System.currentTimeMillis()+String.valueOf(key);
    }
}
