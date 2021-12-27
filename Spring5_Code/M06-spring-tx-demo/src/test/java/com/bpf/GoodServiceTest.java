package com.bpf;

import com.bpf.service.BuyGoodService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GoodServiceTest {

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
         * 定义的对象个数：12
         * ...
         */
    }

    @Test
    public void testBuyWithoutTx() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BuyGoodService buyGoodService = (BuyGoodService) ctx.getBean("buyGoodService");
        // buyGoodService.buy(1001, 10);

        // 商品不存在
        // buyGoodService.buy(1005, 10);

        // 库存不足
        buyGoodService.buy(1001, 10);
    }

    @Test
    public void testBuyWithTx() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BuyGoodService buyGoodService = (BuyGoodService) ctx.getBean("buyGoodService");
        // buyGoodService.buy(1001, 10);

        // 商品不存在
        // buyGoodService.buy(1005, 10);

        // 库存不足
        buyGoodService.buy(1001, 100);
    }
}
