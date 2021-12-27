package com.bpf.xml;

import com.bpf.anno.resource.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoResource {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("anno-resource-applicationContext.xml");
        Student student = (Student) ctx.getBean("student");
        student.sayHello();

        /** 执行结果
         * <com.bpf.anno.resource> [StudentServiceImpl] sayHello()...
         */
    }
}
