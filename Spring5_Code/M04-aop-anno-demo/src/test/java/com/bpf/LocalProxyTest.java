package com.bpf;

import com.bpf.local.proxy.ServiceProxy;
import com.bpf.local.service.impl.SomeServiceImpl;
import org.junit.Test;

public class LocalProxyTest {

    /**
     * 测试本地静态代理模式
     */
    @Test
    public void test() {
        ServiceProxy proxy = new ServiceProxy(new SomeServiceImpl());
        proxy.doSome("今天买了一支笔");

        proxy.doOther("明天要考试了", 20211225);

        /** 执行结果
         * [ServiceProxy] doSome()... 方法前执行：代理对象进行了日志记录
         * [SomeServiceImpl] doSome(): 今天买了一支笔
         * [SomeServiceImpl] doOther(): 明天要考试了 - <20211225>
         * [ServiceProxy] doOther()... 方法后执行：代理对象进行了方法信息记录
         */
    }
}
