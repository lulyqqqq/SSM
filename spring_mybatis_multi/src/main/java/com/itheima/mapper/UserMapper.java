package com.itheima.mapper;


import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper{

        @Select("select * from user")
        @Results({
                //id=true 表面该列是主键
                @Result(id=true, column = "id",property = "id"),
                @Result(column = "username",property = "username"),
                @Result(column = "password",property = "password"),
                @Result(
                        property = "orderList",//要封装的属性名称
                        column = "id", //跟据哪个字段去查询user表的数据
                        javaType = List.class,//要封装的实体类型
                        //select属性 代表查询哪个接口的方法获得数据
                        //根据查询order接口里查询user id 的方法返回user id 给column 从而获得user对应的order表数据
                        many = @Many(select = "查询order表的user id的方法")
                )


        })
        List<User> findAll();

        @Select("select * from user")
        @Results({
                //id=true 表面该列是主键
                @Result(id=true, column = "id",property = "id"),
                @Result(column = "username",property = "username"),
                @Result(column = "password",property = "password"),
                @Result(
                        property = "roleList",//要封装的属性名称
                        column = "id", //跟据哪个字段去查询user表的数据
                        javaType = List.class,//要封装的实体类型
                        //select属性 代表查询哪个接口的方法获得数据
                        //根据查询UserAndOrder接口里查询user id 的方法返回与role id对应user id 给column
                        // 从而获得user对应的role表数据
                        many = @Many(select = "查询UserAndRole表的user id的方法")

                )


        })
        List<User> findUserAndRole();
}
