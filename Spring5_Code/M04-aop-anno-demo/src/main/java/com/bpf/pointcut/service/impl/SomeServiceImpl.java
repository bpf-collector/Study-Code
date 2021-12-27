package com.bpf.pointcut.service.impl;

import com.bpf.pointcut.service.SomeService;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public String doSome(String msg) {
        System.out.println("[SomeServiceImpl] doSome(): " + msg);

        if (Math.random() > 0.6) {
            int i = 10 / 0;
        }

        return "doSome(): " + msg;
    }
}
