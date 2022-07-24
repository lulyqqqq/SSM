package com.itheima.web;

import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: UserServlet
 * @author: mafangnian
 * @date: 2022/4/16 13:38
 * @Blog: null
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从监听器放入到request域中获得 上下文对象(spring容器)
//        ServletContext servletContext = this.getServletContext();
        ServletContext servletContext = req.getServletContext();
        //解除固定的app的名字用工具类来获取 解耦
//        ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
        //使用工具类返回上下文对象的名字来获取上下文对象
//        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        //使用spring-web包的工具类
        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
