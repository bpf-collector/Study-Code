package com.bpf;

import com.bpf.bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;

@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class SpringTest03 {

    @Resource
    private Student student;

    @Test
    public void test() {
        System.out.println("student = " + student);
    }
}
