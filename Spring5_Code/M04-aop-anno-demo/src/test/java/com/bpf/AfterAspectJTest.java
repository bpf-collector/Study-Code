package com.bpf;

import com.bpf.after.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AfterAspectJTest {

    /**
     * 测试后置通知
     */
    @Test
    public void testBefore() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("after-applicationContext.xml");

        SomeService someService = (SomeService) ctx.getBean("someServiceImpl");

        try {
            String result = someService.doSome("今天买了一支笔");
            System.out.println("业务方法的执行结果：result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /** 执行结果
         * [SomeServiceImpl] doSome(): 今天买了一支笔
         * [MyAfterAspect] （最终通知） 目标方法的最后执行：记录完成时间 Fri Dec 24 20:47:35 CST 2021
         * 业务方法的执行结果：result = doSome(): 今天买了一支笔
         */
    }
}
