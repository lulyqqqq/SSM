package com.itheima.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyAspect
 * @author: mafangnian
 * @date: 2022/4/25 23:16
 * @Blog: null
 */
@Component("MyAspect")
@Aspect //标注当前的MyAspect是一个切面类
public class MyAspect {

//    @Before("execution(public void *.itheima.anno.*.*(..))")
    @Before("pointcut()")
    public void before(){
        System.out.println("前置增强.....");
    }
    @AfterReturning("execution(public void *.itheima.anno.*.*(..))")
    public void afterReturning(){
        System.out.println("后置增强.....");
    }

    //Proceeding JoinPoint:正在执行的连接点=====切点
    @Around("execution(public void *.itheima.anno.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前置增强.....");
        //切点方法
        Object proceed = pjp.proceed();
        System.out.println("环绕前置增强.....");
        return proceed;
    }

    public void afterThrowing(){
        System.out.println("异常抛出异常.....");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("最终增强.....");
    }

    //定义切点表达式
    @Pointcut("execution(public void *.itheima.anno.*.*(..))")
    public void pointcut(){
    }
}
