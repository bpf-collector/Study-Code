package com.bpf;

import com.bpf.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTest02 {

    @Resource
    private Student student;

    @Test
    public void test() {
        System.out.println("student = " + student);
    }
}
