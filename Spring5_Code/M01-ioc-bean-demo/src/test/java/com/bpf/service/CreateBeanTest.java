package com.bpf.service;

import com.bpf.service.impl.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;

public class CreateBeanTest {

    /**
     * 传统方式: new 获取对象
     */
    @Test
    public void testCreateBeanClassical() {
        SomeService someService = new SomeServiceImpl();
        someService.doSome();
    }

    /**
     * 使用 Spring 容器方式获取对象
     */
    @Test
    public void testCreateBean() {
        // 创建容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        // 通过 getBean() 获取 bean 对象
        SomeService someService = (SomeService) ctx.getBean("someService");
        // 调用对象方法
        someService.doSome();
    }

    /**
     * Spring 创建对象，调用的是类的哪个构造器呢？
     *  默认调用的是类的无参构造器！
     */
    @Test
    public void testCreateStyle() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        SomeService someService = (SomeService) ctx.getBean("someService");
        someService.doSome();
        // 在无参构造器上添加输出语句，如果把无参构造器改成有参构造器，执行测试方法时会报错：无法找到默认的构造方法。

        /** 执行结果
         * [SomeServiceImpl] 无参构造方法
         * [SomeServiceImpl] someService()...
         */
    }

    /**
     * Spring 创建对象，是什么时候创建的呢？
     *   Spring在创建容器对象 ApplicationContext时，会读取配置文件，并创建文件中声明的所有java对象。
     *
     * 优点：获取对象速度快。
     * 缺点：占用内存。
     */
    @Test
    public void testCreateTime() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        /** 执行结果
         * [SomeServiceImpl] 无参构造方法
         * [SomeServiceImpl] 无参构造方法
         */
    }

    /**
     * 获取Spring容器中的对象信息
     */
    @Test
    public void testGetCtxInfo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        // 容器中对象的数量
        int count = ctx.getBeanDefinitionCount();
        // 容器中对象的名称
        String[] names = ctx.getBeanDefinitionNames();

        System.out.println("容器中对象的数量：" + count);
        System.out.println("容器中对象的名称：" + Arrays.toString(names));

        /** 执行结果
         * [SomeServiceImpl] 无参构造方法
         * [SomeServiceImpl] 无参构造方法
         * 容器中对象的数量：2
         * 容器中对象的名称：[someService, someService1]
         */
    }

    /**
     * 创建非自定义对象
     */
    @Test
    public void testOtherBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Date date = (Date) ctx.getBean("mydate");
        System.out.println("date = " + date);

        /** 执行结果
         * [SomeServiceImpl] 无参构造方法
         * [SomeServiceImpl] 无参构造方法
         * date = Wed Dec 22 19:35:37 CST 2021
         */
    }
}
