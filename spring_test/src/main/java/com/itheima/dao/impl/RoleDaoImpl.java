package com.itheima.dao.impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName: RoleDaoImpl
 * @author: mafangnian
 * @date: 2022/4/23 20:35
 * @Blog: null
 */
public class RoleDaoImpl implements RoleDao {
    //创建jdbc模板类
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 返回查询sys_role表的所有成员信息
     * @return roleList
     */
    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList ;
    }

    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values (?,?,?)",null,role.getRoleName(),role.getRoleDesc());

    }

    public List<Role> findRoleById(Long id) {
        List<Role> roles = jdbcTemplate.query("select * from sys_user_role ur,sys_role r where ur.roleId = r.Id and ur.userId=?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return roles;
    }
}
