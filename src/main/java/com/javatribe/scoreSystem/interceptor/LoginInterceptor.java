package com.javatribe.scoreSystem.interceptor;

import com.javatribe.scoreSystem.cache.LoginCache;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/7/16 22:14
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        String token = request.getHeader("Authorization");
        if (token != null && !token.trim().equals("") && LoginCache.isLogined(token)) {
            return true;
        } else {
            response.getWriter().write("{\"message\": \"未登录！请先进行登录！\", \"code\": 4000}");
            return false;
        }

    }

}
