package com.itheima.resolver;

import com.itheima.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: MyExceptionResolver
 * @author: mafangnian
 * @date: 2022/4/25 20:55
 * @Blog: null
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    /**
     * 参数Exception : 异常对象
     * 返回值ModelAndView视图对象
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof MyException){
            modelAndView.addObject("info","自定义的异常");
        }else if (e instanceof ClassCastException){
            modelAndView.addObject("info","类转换异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
