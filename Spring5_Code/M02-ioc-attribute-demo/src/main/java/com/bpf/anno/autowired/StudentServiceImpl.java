package com.bpf.anno.autowired;

import com.bpf.anno.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements UserService {

    @Override
    public void sayHello() {
        System.out.println("<com.bpf.anno.autowired> [StudentServiceImpl] sayHello()...");
    }
}
