package com.bpf.xml;

import com.bpf.anno.autowired.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoAutowired {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("anno-autowired-applicationContext.xml");
        Student student = (Student) ctx.getBean("student");
        student.sayHello();

        /** 执行结果
         * <com.bpf.anno.autowired> [StudentServiceImpl] sayHello()...
         *
         * 当 StudentServiceImpl 类去掉 @Service 注解，Student 类中引用类型 userService 注解改成 @Autowired(required=false) 时：
         * 会抛出空指针异常，因为在 Student 的 sayHello() 方法中，userService未成功赋值，所以在真正使用上并不会修改 required
         */
    }
}
