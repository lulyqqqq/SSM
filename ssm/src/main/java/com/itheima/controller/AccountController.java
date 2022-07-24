package com.itheima.controller;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName: AccountController
 * @author: mafangnian
 * @date: 2022/5/1 15:59
 * @Blog: null
 */
@Controller
@RequestMapping(value = "/account",produces = "text/html;charset=UTF-8")
public class AccountController {

    @Autowired
    private AccountService accountService;
    //保存
    @RequestMapping("/save")
    @ResponseBody
    public String save(Account account) throws IOException {
        accountService.save(account);
        return "保存成功";
    }

    //查询
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws IOException {
        List<Account> accountList= accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(accountList);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }

}
