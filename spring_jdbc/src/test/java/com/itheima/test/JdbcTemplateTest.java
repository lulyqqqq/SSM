package com.itheima.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import java.beans.PropertyVetoException;
/**
 * @ClassName: JdbcTemplateTest
 * @author: mafangnian
 * @date: 2022/4/23 16:05
 * @Blog: null
 */
public class JdbcTemplateTest {
    @Test
    public  void test1() throws PropertyVetoException {
        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/game");
        dataSource.setUser("root");
        dataSource.setPassword("nian0209");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象 知道数据库在哪
        jdbcTemplate.setDataSource(dataSource);
        //执行操作
        int row = jdbcTemplate.update("insert into account values (?,?)","jam",4000);
        System.out.println(row);
    }

    @Test
    public  void test2() throws PropertyVetoException {
        ApplicationContext app  = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into account values (?,?)","zhangsan",10000);
        System.out.println(row);
    }
}
