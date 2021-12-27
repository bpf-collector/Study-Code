package com.bpf.local.service.impl;

import com.bpf.local.service.SomeService;
import org.springframework.stereotype.Service;

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
