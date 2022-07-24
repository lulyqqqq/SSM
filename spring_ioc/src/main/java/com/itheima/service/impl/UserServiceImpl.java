package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class  UserServiceImpl implements UserService {

    private UserDao userDao;

    //构造器注入
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

//    set方法注入
//    public void setUserDao(UserDao userDao) {
//                this.userDao = userDao;
//            }
    public void save() {
        userDao.save();
    }
}
