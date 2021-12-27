package com.bpf.service.impl;

import com.bpf.service.SomeService;

public class SomeServiceImpl implements SomeService {

    public SomeServiceImpl() {
        System.out.println("[SomeServiceImpl] 无参构造方法");
    }

    @Override
    public void doSome() {
        System.out.println("[SomeServiceImpl] someService()...");
    }
}
