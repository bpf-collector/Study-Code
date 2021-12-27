package com.bpf.anno.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    /**
     * @Value 注解：为属性赋值
     * 使用位置：
     *      1. 属性声明上：无需setter方法
     *      2. setter方法上：需要setter方法且会调用setter方法
     */
    @Value("${stu.name}")
    private String name;
    private Integer age;

    public void setName(String name) {
        System.out.println("name = " + name);
        this.name = name;
    }

    @Value("${stu.age}")
    public void setAge(Integer age) {
        System.out.println("age = " + age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
