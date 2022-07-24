package com.itheima.test;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName: MyBastisTest
 * @author: mafangnian
 * @date: 2022/4/28 11:13
 * @Blog: null
 */
public class MyBatisTest {


    @Test
    public void test4() throws IOException {

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session过工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        sqlSession.insert("userMapper.delete",3);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        //模拟user对象
        User user = new User();
        user.setId(1);
        user.setUsername("tom");
        user.setPassword("abc");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session过工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        sqlSession.insert("userMapper.update",user);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        //模拟user对象
        User user = new User();
        user.setUsername("tom");
        user.setPassword("abc");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session过工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象 参数为true 设置为自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作
        sqlSession.insert("userMapper.save",user);
        //提交事务
//        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Test
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session过工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        List<User> userList = sqlSession.selectList("UserMapper.findAll");
        //测试 打印
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }
}
