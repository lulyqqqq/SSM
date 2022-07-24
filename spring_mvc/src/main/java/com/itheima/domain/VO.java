package com.itheima.domain;

import java.util.List;

/**
 * @ClassName: VO
 * @author: mafangnian
 * @date: 2022/4/18 22:02
 * @Blog: null
 */
public class VO {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "VO{" +
                "userList=" + userList +
                '}';
    }
}
