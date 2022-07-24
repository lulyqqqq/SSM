package com.itheima.proxy.jdk;

/**
 * @ClassName: Target
 * @author: mafangnian
 * @date: 2022/4/25 22:10
 * @Blog: null
 */
public class Target implements TargetInterface{
    @Override
    public void save() {
        System.out.println("save running....");
    }
}
