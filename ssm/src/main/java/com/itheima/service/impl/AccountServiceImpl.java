package com.itheima.service.impl;

import com.itheima.domain.Account;
import com.itheima.mapper.AccountMapper;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName: AccountService
 * @author: mafangnian
 * @date: 2022/5/1 15:57
 * @Blog: null
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void save(Account account) throws IOException {
        //由spring来创建工厂对象 简化了代码
        accountMapper.save(account);

    }

    @Override
    public List<Account> findAll() throws IOException {
        //由spring来创建工厂对象 简化了代码
        return accountMapper.findAll();
    }
}
