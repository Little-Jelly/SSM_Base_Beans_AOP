package com.yyf.aspectj.annotation.target;

import org.springframework.stereotype.Component;

//@Component(name="userDao")

@Component("userDao")
public class B_UserDao implements I_UserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
