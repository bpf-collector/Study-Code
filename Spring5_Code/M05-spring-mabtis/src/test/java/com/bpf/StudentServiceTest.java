package com.bpf;

import com.bpf.bean.Student;
import com.bpf.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentServiceTest {

    // 获取 Spring 容器中的对象
    @Test
    public void testSpringInfo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("定义的对象个数：" + ctx.getBeanDefinitionCount());
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("\t" + name + " ==> " + ctx.getBean(name));
        }

        /** 执行结果
         * 定义的对象个数：11
         * 	org.springframework.context.support.PropertySourcesPlaceholderConfigurer#0 ==> org.springframework.context.support.PropertySourcesPlaceholderConfigurer@6221a451
         * 	dataSource ==> {
         * 	    CreateTime:"2021-12-25 19:17:26",
         * 	    ActiveCount:0,
         * 	    PoolingCount:0,
         * 	    CreateCount:0,
         * 	    DestroyCount:0,
         * 	    CloseCount:0,
         * 	    ConnectCount:0,
         * 	    Connections:[]
         *  }
         * 	sqlSessionFactory ==> org.apache.ibatis.session.defaults.DefaultSqlSessionFactory@3012646b
         * 	org.mybatis.spring.mapper.MapperScannerConfigurer#0 ==> org.mybatis.spring.mapper.MapperScannerConfigurer@4a883b15
         * 	studentService ==> com.bpf.service.impl.StudentServiceImpl@25641d39
         * 	studentDao ==> org.apache.ibatis.binding.MapperProxy@7b36aa0c
         * 	org.springframework.context.annotation.internalConfigurationAnnotationProcessor ==> org.springframework.context.annotation.ConfigurationClassPostProcessor@5824a83d
         * 	org.springframework.context.annotation.internalAutowiredAnnotationProcessor ==> org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@537f60bf
         * 	org.springframework.context.annotation.internalCommonAnnotationProcessor ==> org.springframework.context.annotation.CommonAnnotationBeanPostProcessor@5677323c
         * 	org.springframework.context.event.internalEventListenerProcessor ==> org.springframework.context.event.EventListenerMethodProcessor@18df8434
         * 	org.springframework.context.event.internalEventListenerFactory ==> org.springframework.context.event.DefaultEventListenerFactory@65c7a252
         */
    }

    // 插入数据
    @Test
    public void testInsert() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentService service = (StudentService) ctx.getBean("studentService");

        service.addStudent(new Student("Tom", 14));
        service.addStudent(new Student("Marry", 15));
    }

    // 查询数据
    @Test
    public void testQuery() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentService service = (StudentService) ctx.getBean("studentService");

        service.queryStudent().forEach(System.out::println);

        /** 执行结果
         * Student{id=1, name='Tom', age=14}
         * Student{id=2, name='Marry', age=15}
         */
    }
}
