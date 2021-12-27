package com.bpf.dao;

import com.bpf.bean.Student;

import java.util.List;

public interface StudentDao {

    int insertStudent(Student student);

    List<Student> selectStudents();
}
