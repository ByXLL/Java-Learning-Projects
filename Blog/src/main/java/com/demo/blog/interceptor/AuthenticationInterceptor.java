package com.demo.blog.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.demo.blog.annotation.LoginTokenRequired;
import com.demo.blog.annotation.PassTokenRequired;
import com.demo.blog.entity.User;
import com.demo.blog.exception.LoginException;
import com.demo.blog.service.UserService;
import com.demo.blog.utils.CommUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * token 权限拦截器
 * @author By-Lin
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    private final UserService userService;

    public AuthenticationInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 从请求中获取 token 字段
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){ return true; }

        // 获取当前请求的控制器方法
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        //检查是否有 PassTokenRequired 注释，有则跳过认证
        if (method.isAnnotationPresent(PassTokenRequired.class)) {
            PassTokenRequired passToken = method.getAnnotation(PassTokenRequired.class);
            if(passToken.required()) { return true; }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(LoginTokenRequired.class)) {
            LoginTokenRequired userLoginToken = method.getAnnotation(LoginTokenRequired.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new LoginException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId;
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new LoginException("401,权限异常");
                }
                User user = userService.findUserEntityById(Integer.parseInt(userId));
                if (user == null) {
                    throw new LoginException("用户不存在，请重新登录");
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(CommUtils.SECRET)).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new LoginException("401,权限异常");
                }
                return true;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
