package com.bpf.xml;

import com.bpf.xml.autowired.Phone;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAutowired {

    /**
     * 使用 Spring 进行属性赋值
     */
    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("xml-autowired-applicationContext.xml");
        Phone phone = (Phone) ctx.getBean("phone1");
        System.out.println("phone = " + phone);

        phone = (Phone) ctx.getBean("phone2");
        System.out.println("phone = " + phone);

        /** 执行结果
         * phone = Phone{owner='Marry', provider='魅族', card=SIMCard{name='中国移动', number='12434424734'}}
         * phone = Phone{owner='Kate', provider='索爱', card=SIMCard{name='中国移动', number='12434424734'}}
         */
    }
}
