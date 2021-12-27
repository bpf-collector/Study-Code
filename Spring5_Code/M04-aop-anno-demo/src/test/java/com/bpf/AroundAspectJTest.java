package com.bpf;

import com.bpf.around.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AroundAspectJTest {

    /**
     * 测试后置通知
     */
    @Test
    public void testBefore() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("around-applicationContext.xml");

        SomeService someService = (SomeService) ctx.getBean("someServiceImpl");
        String result = someService.doSome("今天买了一支笔");
        System.out.println("业务方法的执行结果：result = " + result);

        /** 执行结果
         * [MyAroundAspect] （环绕通知） 目标方法之前：记录执行时间 Fri Dec 24 20:28:54 CST 2021
         * [SomeServiceImpl] doSome(): 今天买了一支笔
         * [MyAroundAspect] （环绕通知） 目标方法之后：执行事务功能
         * 业务方法的执行结果：result = something here(): 今天买了一支笔
         */
    }
}
