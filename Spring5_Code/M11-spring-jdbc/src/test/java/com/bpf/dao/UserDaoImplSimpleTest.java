package com.bpf.dao;

import com.bpf.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;
import java.util.Arrays;

@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
class UserDaoImplSimpleTest {

    @Resource(name = "userDaoImplSimpleInsert")
    private UserDao userDao;

    @Test
    void insert() {
        System.out.println(userDao.insert(new User("Simple01", "sim123")));
    }

    @Test
    void insertAndReturnKey() {
        System.out.println(userDao.insertAndReturnKey(new User("Simple02", "sim123")));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void count() {
    }

    @Test
    void selectUsers() {
    }

    @Test
    void selectById() {
    }

    @Test
    void batchInsert() {
        System.out.println(userDao.batchInsert(Arrays.asList(
                new User("Simple03", "sim123"),
                new User("Simple04", "sim123"))));
    }

    @Test
    void batchUpdate() {
    }

    @Test
    void batchDelete() {
    }
}