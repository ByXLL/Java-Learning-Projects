package com.brodog.mall.common.util;

import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 公共工具类
 * @author By-Lin
 */
public class CommUtils {
    /***
     * 获取 md5 加密后的字段
     * @param key   需要加密的字段
     * @return      加密后的字段
     */
    public static String getMd5(String key) {
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

    /**
     * 获取ip地址
     * @param request       request请求
     * @return              ip地址 str
     */
    public static String getIpAddr(HttpServletRequest request) {
        String UNKNOWN = "unknown";
        String LOCALHOST = "127.0.0.1";
        String SEPARATOR = ",";

        String ipAddress;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (LOCALHOST.equals(ipAddress)) {
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    assert inet != null;
                    ipAddress = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            // "***.***.***.***".length()
            if (ipAddress != null && ipAddress.length() > 15) {
                if (ipAddress.indexOf(SEPARATOR) > 0) {
                    ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
                }
            }
        } catch (Exception e) {
            ipAddress = "";
        }
        return ipAddress;
    }

    /**
     * 字符串转数组
     * @param str       源字符串
     * @return          字符串数组
     */
    public static ArrayList<String> stringToList(String str) {
        ArrayList<String> newList = new ArrayList<>();
        if(!str.isEmpty()) {
            String[] list = str.split(",");
            newList.addAll(Arrays.asList(list));
        }
        return newList;
    }
}
