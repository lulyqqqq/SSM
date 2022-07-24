package com.itheima.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: MapperTest
 * @author: mafangnian
 * @date: 2022/4/30 14:02
 * @Blog: null
 */
public class MapperTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //模拟条件user
//        User condition = new User();
//        condition.setId(1);
//        condition.setUsername("tom");
////        condition.setPassword("123");
//        List<User> byCondition = mapper.findByCondition(condition);
//
//        System.out.println(byCondition);

        //模拟ids
        List<Integer> ids = new ArrayList<Integer> ();
        ids.add(1);
        ids.add(2);
        List<User> userList = mapper.findByIds(ids);
        System.out.println(userList);


    }
}
