package com.bpf;

import com.bpf.afterreturning.bean.Person;
import com.bpf.afterreturning.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AfterReturningAspectJTest {

    /**
     * 测试后置通知
     */
    @Test
    public void testBefore() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("afterreturning-applicationContext.xml");

        SomeService someService = (SomeService) ctx.getBean("someServiceImpl");
        String result = someService.doSome("今天买了一支笔");
        System.out.println("业务方法的执行结果：result = " + result);

        System.out.println("======================================================================");

        Person tom = someService.doGet("Tom", 12);
        System.out.println("业务方法的执行结果：tom = " + tom);

        /** 执行结果
         * [SomeServiceImpl] doSome(): 今天买了一支笔
         * [MyAfterReturningAspect] （后置通知） 目标方法的执行结果是：doSome(): 今天买了一支笔
         * [MyAfterReturningAspect] （后置通知） 修改方法返回值：string = doSome(): 今天买了一支笔 < AfterReturning
         * 业务方法的执行结果：result = doSome(): 今天买了一支笔
         * ======================================================================
         * [SomeServiceImpl] doGet()...
         * [MyAfterReturningAspect] （后置通知） 目标方法的执行结果是：Person{name='Tom', age=12}
         * [MyAfterReturningAspect] （后置通知） 修改方法返回值：person = Person{name='ZH-Tom', age=12}
         * 业务方法的执行结果：tom = Person{name='ZH-Tom', age=12}
         */
    }
}
