package com.bpf.afterreturning.service.impl;

import com.bpf.afterreturning.bean.Person;
import com.bpf.afterreturning.service.SomeService;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public String doSome(String msg) {
        System.out.println("[SomeServiceImpl] doSome(): " + msg);

        return "doSome(): " + msg;
    }

    @Override
    public Person doGet(String name, Integer age) {
        System.out.println("[SomeServiceImpl] doGet()...");
        return new Person(name, age);
    }
}
