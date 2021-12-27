package com.bpf.dao.impl;

import com.bpf.bean.User;
import com.bpf.dao.UserDao;

public class MySqlUserDao implements UserDao {
    @Override
    public void insertUser(User user) {
        System.out.println("通过MySQL插入用户：" + user);
    }
}
