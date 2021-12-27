package com.bpf.anno.resource;

import com.bpf.anno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Student {

    /**
     * @Resource 注解：为属性赋值
     * 使用位置：
     *      1. 属性声明上：无需setter方法
     *      2. setter方法上：需要setter方法且会调用setter方法
     * 属性：
     *      boolean required: 表示此属性是否必须，默认值为true。表示当对应的java对象为null时会抛出异常。
     *          org.springframework.beans.factory.NoSuchBeanDefinitionException
     */
    // @Resource(name = "userService")
    @Resource
    private UserService userService;

    public void sayHello() {
        userService.sayHello();
    }
}
