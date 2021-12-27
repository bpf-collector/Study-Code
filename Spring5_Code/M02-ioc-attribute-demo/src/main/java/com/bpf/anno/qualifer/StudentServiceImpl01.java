package com.bpf.anno.qualifer;

import com.bpf.anno.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl01 implements UserService {

    @Override
    public void sayHello() {
        System.out.println("<com.bpf.anno.qualifer> [StudentServiceImpl01] sayHello()...");
    }
}
