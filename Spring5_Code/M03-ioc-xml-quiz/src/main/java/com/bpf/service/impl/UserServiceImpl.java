package com.bpf.service.impl;

import com.bpf.bean.User;
import com.bpf.dao.UserDao;
import com.bpf.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.insertUser(user);
    }
}
