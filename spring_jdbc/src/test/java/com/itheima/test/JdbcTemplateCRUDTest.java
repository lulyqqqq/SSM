package com.itheima.test;

import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName: JdbcTemplateCRUDTest
 * @author: mafangnian
 * @date: 2022/4/23 18:29
 * @Blog: null
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {
    @Autowired//从Spring容器里拿出JdbcTemplate自动注入
    private JdbcTemplate jdbcTemplate;





    //需要计算聚合函数的查询
    @Test
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);
    }

    //查询单个
    @Test
    public void testQueryOne(){
        Account account = jdbcTemplate.queryForObject("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), "tom");
        System.out.println(account);
    }

    //查询所有
    @Test
    public void testQueryAll(){
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    @Test
    public void testUpdate(){
        int row = jdbcTemplate.update("update account set money=? where name = ?", 1000, "tom");
        System.out.println(row);
    }
    @Test
    public void testDelete(){
        int row = jdbcTemplate.update("delete from account where name = ?",  "tom");
        System.out.println(row);
    }
}
