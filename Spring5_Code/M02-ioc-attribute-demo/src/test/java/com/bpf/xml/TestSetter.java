package com.bpf.xml;

import com.bpf.xml.setter.Phone;
import com.bpf.xml.setter.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestSetter {

    /**
     * 使用 Spring 进行属性赋值
     */
    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("xml-setter-applicationContext.xml");
        Student student = (Student) ctx.getBean("student");
        System.out.println("student = " + student);

        Date date = (Date) ctx.getBean("mydate");
        System.out.println("date = " + date);

        /** 执行结果
         * student = Student{name='Tom', age=12}
         * date = Fri Dec 31 20:22:07 CST 2010
         */
    }

    /**
     * 如果删除 Student 类中的 setter() 方法，再次测试会报错：name 属性不可写或没有 setter 方法。
     *
     * 说明 xml 中的 property 标签使用的是属性的setter方法进行赋值的。
     */

    /**
     * 如果不删除setter方法，而是增加setter方法呢？
     *   在 Student 类中增加 setEmail() 方法，但不增加 email 属性，能否正常注入呢？
     *
     * 可以，只要存在setter方法就行，并且 Spring 不关心 setter方法的具体实现。
     */
    @Test
    public void test02() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("xml-setter-applicationContext.xml");
        Student student = (Student) ctx.getBean("emailStudent");
        System.out.println("student = " + student);

        /** 执行结果
         * [Student] setEmail(): tom@qq.com
         * student = Student{name='Tim', age=14}
         */
    }

    /**
     * 测试引用类型
     */
    @Test
    public void test03() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("xml-setter-applicationContext.xml");
        Phone phone = (Phone) ctx.getBean("phone");
        System.out.println("phone = " + phone);

        /** 执行结果
         * [Student] setEmail(): tom@qq.com
         * phone = Phone{owner='Tom', provider='华为', card=SIMCard{name='中国电信', number='12448277394'}}
         */
    }
}
