package com.bpf.service;

import com.bpf.bean.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);

    List<Student> queryStudent();
}
