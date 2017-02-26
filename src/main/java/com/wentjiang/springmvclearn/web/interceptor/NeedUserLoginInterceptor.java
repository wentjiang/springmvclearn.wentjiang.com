package com.wentjiang.springmvclearn.web.interceptor;

import com.wentjiang.springmvclearn.annotation.NeedUserLogin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wentj on 2017/2/22.
 */
public class NeedUserLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = null;
        if (handler instanceof HandlerMethod){
            handlerMethod = (HandlerMethod) handler;
        }
        if (handlerMethod != null){
            NeedUserLogin needUserLogin = handlerMethod.getClass().getAnnotation(NeedUserLogin.class);
            if (needUserLogin != null && needUserLogin.isNeed()) {
                System.out.println("判断用户是否登录");
            }
        }
        return true;
    }
}
