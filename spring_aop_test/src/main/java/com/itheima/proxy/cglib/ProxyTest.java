package com.itheima.proxy.cglib;

import com.itheima.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: ProxyTest
 * @author: mafangnian
 * @date: 2022/4/25 22:12
 * @Blog: null
 */
public class ProxyTest {
    public static void main(String[] args) {
        //目标对象
        final Target target = new Target();
        //增强对象
        Advice advice = new Advice();

        //返回动态代理的对象 基于cglib
        //1.设置增强器
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(Target.class);
        //3.设置回调
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                //执行前置
                advice.before();
                Object invoke = method.invoke(target, args);//执行目标
                //执行后置
                advice.afterReturning();
                return invoke;
            }
        });
        //4.创建代理对象
         Target proxy = (Target) enhancer.create();


         proxy.save();
    }
}
