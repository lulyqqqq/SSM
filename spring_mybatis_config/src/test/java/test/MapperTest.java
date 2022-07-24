package test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: MapperTest
 * @author: mafangnian
 * @date: 2022/4/30 14:02
 * @Blog: null
 */
public class MapperTest {


    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        //设置分页相关参数  当前页 每页显示的数目
        PageHelper.startPage(1, 3);

        //保存对象
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

        //获得与分页相关参数 当前页 下一页。。。。
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("当前页"+pageInfo.getPageNum());
        System.out.println("每页显示条数"+pageInfo.getPageSize());
        System.out.println("总条数"+pageInfo.getTotal());
        System.out.println("总页数"+pageInfo.getPages());
        System.out.println("上一页"+pageInfo.getPrePage());
        System.out.println("下一页"+pageInfo.getNextPage());
        System.out.println("是否是第一个"+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一个"+pageInfo.isIsLastPage());
        sqlSession.close();


    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        //保存对象
        User user = mapper.findById(4);

        System.out.println(user.getBirthday());
        sqlSession.commit();
        sqlSession.close();


    }

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
//        user.setId(3);
        user.setUsername("cesh");
        user.setPassword("111");
        user.setBirthday(new Date());
        //保存对象
        mapper.save(user);

        sqlSession.commit();
        sqlSession.close();


    }
}
