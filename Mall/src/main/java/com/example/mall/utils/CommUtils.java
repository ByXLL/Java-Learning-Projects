package com.example.mall.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.mall.entity.User;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * 公共公共工具类
 * @author By-Lin
 */
public class CommUtils {
    public final static String SECRET =  "fhsrjoquohtrnznewpopnks";
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
     * 获取用户token
     * @param user      用户实体
     * @return          token
     */
    public static String getToken(User user) {
        int time = 60 * 60 * 1000;
        Long now = System.currentTimeMillis();
        Long expMils = now + time;
        String token="";
        token= JWT.create().withAudience(String.valueOf(user.getId()))
                .withExpiresAt(new Date(expMils))
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    /**
     * 校验是否是 手机大陆手机号码
     * @param str       手机号码
     * @return          布尔值
     */
    public static boolean isChinaPhoneLegal(String str){
        // ^ 匹配输入字符串开始的位置
        // \d 匹配一个或多个数字，其中 \ 要转义，所以是 \\d
        // $ 匹配输入字符串结尾的位置
        String regExp = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])" +
                "|(18[0-9])|(19[8,9]))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
