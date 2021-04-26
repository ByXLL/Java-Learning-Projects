package com.brodog.mall.admin;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 应用启动类
 * ComponentScan 设置扫描组件的包路径，不然无法扫到 common 层的组件和配置
 * EnableTransactionManagement 开启事务配置
 * @author By-Lin
 */
@SpringBootApplication
@ComponentScan("com.brodog")
@EnableTransactionManagement(proxyTargetClass = true)
public class MallAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallAdminApplication.class);
    }
}
