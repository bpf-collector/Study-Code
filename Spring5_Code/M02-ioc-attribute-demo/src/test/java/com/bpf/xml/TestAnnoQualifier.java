package com.bpf.xml;

import com.bpf.anno.qualifer.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoQualifier {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("anno-qualifier-applicationContext.xml");
        Student student = (Student) ctx.getBean("student");
        student.sayHello();

        /** 执行结果
         * <com.bpf.anno.qualifer> [StudentServiceImpl01] sayHello()...
         *
         * 或
         *
         * <com.bpf.anno.qualifer> [StudentServiceImpl01] sayHello()...
         */
    }
}
