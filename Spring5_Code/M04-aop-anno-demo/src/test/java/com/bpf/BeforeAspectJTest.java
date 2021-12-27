package com.bpf;

import com.bpf.before.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeforeAspectJTest {

    /**
     * 测试前置通知
     *
     * 当有多个切面匹配同一个目标方法时，无法预知哪个切面先执行。
     */
    @Test
    public void testBefore() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("before-applicationContext.xml");

        SomeService someService = (SomeService) ctx.getBean("someServiceImpl");
        someService.doSome("今天买了一支笔");
        someService.doOther("明天要考试了", 20211225);

        /** 执行结果
         * [MyBeforeAspect] （前置通知） 当前执行时间：Fri Dec 24 18:58:56 CST 2021
         * [MyBeforeAspect] （前置通知） 当前正在运行的方法是：
         * 	Sign: void com.bpf.before.service.SomeService.doSome(String)
         * 	Target: com.bpf.before.service.impl.SomeServiceImpl@3cc1435c
         * 	Kind: method-execution
         * 	Args: [今天买了一支笔]
         * [SomeServiceImpl] doSome(): 今天买了一支笔
         * [MyBeforeAspect] （前置通知） 当前正在运行的方法是：
         * 	Sign: void com.bpf.before.service.SomeService.doOther(String,Integer)
         * 	Target: com.bpf.before.service.impl.SomeServiceImpl@3cc1435c
         * 	Kind: method-execution
         * 	Args: [明天要考试了, 20211225]
         * [SomeServiceImpl] doOther(): 明天要考试了 - <20211225>
         */
    }
}
