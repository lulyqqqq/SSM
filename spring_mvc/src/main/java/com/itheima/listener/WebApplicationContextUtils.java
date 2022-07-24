package com.itheima.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @ClassName: WebApplicationContextUtils
 * @author: mafangnian
 * @date: 2022/4/16 16:34
 * @Blog: null
 */
public class WebApplicationContextUtils {
    /**
     * 解耦 上下文对象 名字
     * @param servletContext
     * @return
     */
    public static ApplicationContext getWebApplicationContext(ServletContext servletContext){
        return (ApplicationContext)servletContext.getAttribute("app");
    }
}
