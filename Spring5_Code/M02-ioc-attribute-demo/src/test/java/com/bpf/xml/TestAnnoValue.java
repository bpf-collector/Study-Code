package com.bpf.xml;

import com.bpf.anno.value.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoValue {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("anno-value-applicationContext.xml");
        Student student = (Student) ctx.getBean("student");
        System.out.println("student = " + student);

        /** 执行结果
         * age = 13
         * student = Student{name='凯特斯', age=13}
         */
    }
}
