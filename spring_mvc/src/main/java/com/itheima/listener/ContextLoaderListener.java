package com.itheima.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName: ContextLoaderListener
 * @author: mafangnian
 * @date: 2022/4/16 15:55
 * @Blog: null
 */
public class ContextLoaderListener implements ServletContextListener {
    //上下文初始化运行的方法
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        //读取web.xml中的全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //获取spring上下文对象
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);
        //将spring上下文对象存储到ServletContext域中
        //上下文对象存入到ServletContext域中 名字是耦合死的 在运用的时候需要解耦方便写
        servletContext.setAttribute("app",app);
        System.out.println("spring容器创建完毕------init.......");

    }

    //上下文销毁后运行的方法
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Listener destroy.......");

    }
}
