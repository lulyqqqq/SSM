package com.itheima.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @ClassName: DateHandler
 * @author: mafangnian
 * @date: 2022/4/30 19:08
 * @Blog: null
 */
public class DateHandler extends BaseTypeHandler<Date> {
    //将Java类型转换成数据库需要的类型
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        preparedStatement.setLong(i,time);
    }

    //将数据库中类型 转换成Java类型
    //String参数 要转换的字段名称
    //ResultSet 查询结果的结果集
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        //获得结果集中需要的数据(long)转换成Date类型 返回
        long aLong = resultSet.getLong(s);
        Date date = new Date(aLong);
        return date;
    }
    //将数据库中类型 转换成Java类型
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        //获得结果集中需要的数据(long)转换成Date类型 返回
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
    //将数据库中类型 转换成Java类型
    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        //获得结果集中需要的数据(long)转换成Date类型 返回
        long aLong = callableStatement.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
}
