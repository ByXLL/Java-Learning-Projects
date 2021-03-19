package com.demo.blog.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置类
 * 开启Swagger2的自动配置
 * @author By-Lin
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 配置docket以配置Swagger具体参数
     * @return  Docket
     */
    @Bean
    public Docket docket() {
        // Docket 实例关联上 apiInfo()
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    /**
     * 配置文档信息
     * @return  ApiInfo
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("My-Blog的SwaggerApi文档").description("可以直接访问的接口")
            .version("0.1")
            .build();
    }
}
