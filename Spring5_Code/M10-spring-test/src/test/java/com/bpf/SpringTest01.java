package com.bpf;

import com.bpf.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest01 {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = ctx.getBean("student", Student.class);
        System.out.println("student = " + student);
    }
}
