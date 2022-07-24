package com.itheima.proxy.cglib;

/**
 * @ClassName: Advice
 * @author: mafangnian
 * @date: 2022/4/25 22:11
 * @Blog: null
 */
public class Advice {

    public void before(){
        System.out.println("前置增强。。。。");
    }

    public void afterReturning(){
        System.out.println("后置增强。。。。");
    }
}
