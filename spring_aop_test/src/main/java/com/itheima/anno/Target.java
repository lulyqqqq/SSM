package com.itheima.anno;

import org.springframework.stereotype.Component;

/**
 * @ClassName: Target
 * @author: mafangnian
 * @date: 2022/4/25 22:10
 * @Blog: null
 */
@Component("target")
public class Target implements TargetInterface {
    @Override
    public void save() {
        System.out.println("save running....");
    }
}
