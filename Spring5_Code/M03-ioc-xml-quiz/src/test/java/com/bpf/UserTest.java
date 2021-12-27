package com.bpf;

import com.bpf.bean.User;
import com.bpf.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void testAddUser() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = (UserService) ctx.getBean("userService");

        User user = new User("Tommy", 12);
        userService.addUser(user);

        /** 执行结果
         * 通过MySQL插入用户：User{name='Tommy', age=12}
         */
    }
}
