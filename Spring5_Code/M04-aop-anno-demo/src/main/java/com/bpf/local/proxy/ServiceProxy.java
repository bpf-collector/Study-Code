package com.bpf.local.proxy;

import com.bpf.local.service.SomeService;

public class ServiceProxy implements SomeService {

    public ServiceProxy(SomeService target) {
        this.target = target;
    }

    private SomeService target;

    @Override
    public void doSome(String msg) {
        System.out.println("[ServiceProxy] doSome()... 方法前执行：代理对象进行了日志记录");
        target.doSome(msg);
    }

    @Override
    public void doOther(String msg, Integer id) {
        target.doOther(msg, id);
        System.out.println("[ServiceProxy] doOther()... 方法后执行：代理对象进行了方法信息记录");
    }
}
