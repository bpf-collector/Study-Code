package com.bpf.before.service.impl;

import com.bpf.before.service.SomeService;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome(String msg) {
        System.out.println("[SomeServiceImpl] doSome(): " + msg);
    }

    @Override
    public void doOther(String msg, Integer id) {
        System.out.println("[SomeServiceImpl] doOther(): " + msg + " - <" + id + ">");
    }
}
