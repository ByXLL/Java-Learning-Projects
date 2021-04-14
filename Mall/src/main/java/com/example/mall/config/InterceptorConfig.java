package com.example.mall.config;

import com.example.mall.interceptor.AuthenticationInterceptor;
import com.example.mall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 请求拦截器配置
 * @author By-Lin
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private final UserService userService;

    public InterceptorConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 拦截所有请求
         * 放行 swagger
         */
        registry.addInterceptor(authenticationInterceptor())
                .excludePathPatterns(
                        "/swagger-resources/**",
                        "/swagger-ui.html" +
                        "/v2/api-docs" +
                        "/webjars/**"
                )
                .addPathPatterns("/**");
    }
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor(userService);
    }
}
