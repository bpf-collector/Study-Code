package com.bpf.service;

import com.bpf.bean.Student;

public interface StudentService {

    int addStudent(Student student);

    Student queryStudentById(Integer id);
}
