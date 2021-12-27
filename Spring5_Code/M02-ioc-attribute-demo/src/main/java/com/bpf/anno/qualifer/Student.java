package com.bpf.anno.qualifer;

import com.bpf.anno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {

    /**
     * @Qualifier 注解：为属性赋值
     * 使用位置：
     *      1. 属性声明上：无需setter方法
     *      2. setter方法上：需要setter方法且会调用setter方法
     * 属性：
     *      String value: 指定注入bean的id或名称。
     */
    @Autowired
    // @Qualifier // 当不指定 value 值时，由于存在两个同源的bean，因此会抛出异常 NoUniqueBeanDefinitionException
    @Qualifier("studentServiceImpl02")
    private UserService userService;

    public void sayHello() {
        userService.sayHello();
    }
}
