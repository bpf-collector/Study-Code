package com.bpf.dao;

import com.bpf.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
class UserDaoImplNamedParamTest {

    @Resource(name = "userDapImplNamedParam")
    private UserDao userDao;

    @Test
    void insert() {
        System.out.println(userDao.insert(new User("Dark09", "dark123")));
    }

    @Test
    void insertAndReturnKey() {
        System.out.println(userDao.insertAndReturnKey(new User("Dark02", "dark1234")));
    }

    @Test
    void update() {
        User user = new User("Dark01", "dark123");
        user.setId(7);
        System.out.println(userDao.update(user));
    }

    @Test
    void delete() {
        System.out.println(userDao.delete(8));
    }

    @Test
    void count() {
        System.out.println(userDao.count());
    }

    @Test
    void selectUsers() {
    }

    @Test
    void selectById() {
    }

    @Test
    void batchInsert() {
    }

    @Test
    void batchUpdate() {
    }

    @Test
    void batchDelete() {
    }
}