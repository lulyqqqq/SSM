package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

/**
 * @ClassName: UserserviceImpl
 * @author: mafangnian
 * @date: 2022/4/24 15:33
 * @Blog: null
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<User> list() {
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            //获得user的ID
            Long id = user.getId();
            //将id作为参数进行查询userID 对应的role的集合数据
            List<Role> roles = roleDao.findRoleById(id);
            user.setRoles(roles);
        }
        return userList;
    }


    public void save(User user, Long[] roleIds) {
        //1.向sys_user表中存储数据
        Long userId = userDao.save(user);

        //2.向sys_user_role关系表中存储多条数据
        userDao.saveUserRoleRel(userId, roleIds);
    }

    public void del(Long userId) {
        //1.删除sys_user_role表的连接关系
        userDao.delUserRoleRel(userId);
        //2.删除sys_user表的数据
        userDao.del(userId);
    }

    public User login(String username, String password) {
        try {
            User user = userDao.findByUsernameAndPassword(username, password);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
