package com.demo.blog.utils;

import org.springframework.util.DigestUtils;

import java.util.UUID;

/***
 * 公共公共工具类
 */
public class CommUtils {
    /***
     * 生成随机 uuid
     * @return  生成的uuid
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /***
     * 获取 md5 加密后的字段
     * @param key   需要加密的字段
     * @return      加密后的字段
     */
    public static String getMd5(String key) {
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
