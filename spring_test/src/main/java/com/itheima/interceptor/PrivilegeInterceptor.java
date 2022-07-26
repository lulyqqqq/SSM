package com.itheima.interceptor;

import com.itheima.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @ClassName: PrivilegeInterceptor
 * @author: mafangnian
 * @date: 2022/4/25 10:58
 * @Blog: null
 */
public class PrivilegeInterceptor implements HandlerInterceptor {

    //在请求方法之前调用
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //逻辑:判断用户是否登录  本质:判断session中有没有user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null){
            //没有登录
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }
        //放行 访问目标资源
        return true;
    }
}
