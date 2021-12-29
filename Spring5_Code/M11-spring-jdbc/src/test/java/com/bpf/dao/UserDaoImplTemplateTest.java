package com.bpf.dao;

import com.bpf.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
class UserDaoImplTemplateTest {

    @Resource(name = "userDaoImplTemplate")
    private UserDao userDao;

    @Test
    void insert() {
        User user = new User("Tom", "tom123");
        System.out.println(userDao.insert(user));
    }

    @Test
    void insertAndReturnKey() {
        User user = new User("Marry", "mary123");
        System.out.println(userDao.insertAndReturnKey(user));
    }

    @Test
    void update() {
        User user = new User("Mary", "123456");
        user.setId(5);
        System.out.println(userDao.update(user));
    }

    @Test
    void delete() {
        System.out.println(userDao.delete(2));
    }

    @Test
    void count() {
        System.out.println(userDao.count());
    }

    @Test
    void selectUsers() {
        userDao.selectUsers().forEach(System.out::println);
    }

    @Test
    void selectById() {
        System.out.println(userDao.selectById(5));
    }

    @Test
    void batchInsert() {
        List<User> users = Arrays.asList(
                new User("Tidy", "tidy123"),
                new User("Tedy", "tedy123"));

        System.out.println(userDao.batchInsert(users));
    }

    @Test
    void batchUpdate() {
        List<User> users = userDao.selectUsers();
        users.forEach(user -> {
            user.setPassword("123456");
        });

        System.out.println(userDao.batchUpdate(users));
    }

    @Test
    void batchDelete() {
        System.out.println(userDao.batchDelete(Arrays.asList(1, 3)));
    }
}