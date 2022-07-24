package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName: RoleController
 * @author: mafangnian
 * @date: 2022/4/23 20:18
 * @Blog: null
 */
@RequestMapping("/role")
@Controller//web层 注解方式产生bean存入spring容器 需要包扫描
public class RoleController {

    //将roleService注入到RoleController中
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    private ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        //设置模型对象
        modelAndView.addObject("roleList",roleList);
        //设置视图  向哪跳转
        modelAndView.setViewName("role-list");
        System.out.println(roleList);
        return modelAndView;
    }

    @RequestMapping("save")
    public String save(Role role){
        roleService.save(role);
        //重定向到查询所有页面
        return "redirect:/role/list";
    }


}
