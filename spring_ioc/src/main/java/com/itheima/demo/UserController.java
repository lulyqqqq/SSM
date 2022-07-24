package com.itheima.demo;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserController {

    public static void main(String[] args) {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext app = new FileSystemXmlApplicationContext("D:\\Idea-Springboot-projects\\Spring\\spring_ioc\\src\\main\\resources\\applicationContext.xml");
        //这种方式使用的是bean标签的唯一id值 可以使用多个不同样的id属性  根据id获取值
        //        UserService userService = (UserService) app.getBean("userService");
        //getBean根据属性的方式不需要强转    直接读取指定的class
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }

}
