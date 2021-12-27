package com.bpf.around.service.impl;

import com.bpf.around.service.SomeService;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public String doSome(String msg) {
        System.out.println("[SomeServiceImpl] doSome(): " + msg);

        return "doSome(): " + msg;
    }
}
