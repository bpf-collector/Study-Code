package com.bpf.xml;

import com.bpf.xml.constructor.Phone;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestConstructor {

    /**
     * 使用 Spring 进行属性赋值
     *
     * 使用构造器方式，不需要setter方法。
     */
    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("xml-constructor-applicationContext.xml");
        Phone phone = (Phone) ctx.getBean("phone");
        System.out.println("phone = " + phone);

        /** 执行结果
         * phone = Phone{owner='Tom', provider='小米', card=SIMCard{name='中国电信', number='12448277394'}}
         */
    }
}
