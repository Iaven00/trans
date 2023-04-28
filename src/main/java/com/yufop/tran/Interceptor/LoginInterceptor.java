package com.yufop.tran.Interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <Description> LoginInterceptor 登录拦截器，防止不登陆访问后台
 *
 * @author 26802
 * @version 1.0
 * @ClassName LoginInterceptor
 * @taskId
 * @see
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String id = String.valueOf(request.getSession().getAttribute("id"));

        if(id == null){
            System.out.println("认证失败，用户未登录");
            return false;
        }
        System.out.println("已登录，认证成功");
        return true;
    }
}
