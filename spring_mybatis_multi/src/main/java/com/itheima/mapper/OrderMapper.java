package com.itheima.mapper;

import com.itheima.domain.Order;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    @Select("select *, o.oid oid from order o,user u where o.uid = u.id")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "total",property = "total"),
            @Result(
                    property = "user",//要封装的属性名称
                    column = "uid", //跟据哪个字段去查询user表的数据
                    javaType = User.class,//要封装的实体类型
                    //select属性 代表查询哪个接口的方法获得数据
                    //根据查询user接口里查询user id 的方法返回id 给column 从而获得user数据
                    one = @One(select = "查询user表的id的方法")
            )


    })
    List<Order> findAll();
}
