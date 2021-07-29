package com.brodog.mall.app.config;

import com.brodog.mall.app.interceptor.AuthenticationInterceptor;
import com.brodog.mall.app.service.UserService;
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
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor(userService);
    }
}
