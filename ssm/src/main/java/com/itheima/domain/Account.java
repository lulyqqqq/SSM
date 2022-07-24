package com.itheima.domain;

/**
 * @ClassName: Account
 * @author: mafangnian
 * @date: 2022/5/1 15:52
 * @Blog: null
 */
public class Account {
    private int id;
    private String name;
    private double money;

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
