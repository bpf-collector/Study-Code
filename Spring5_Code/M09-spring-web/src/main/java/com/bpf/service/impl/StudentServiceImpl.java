package com.bpf.service.impl;

import com.bpf.bean.Student;
import com.bpf.dao.StudentDao;
import com.bpf.service.StudentService;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public Student queryStudentById(Integer id) {
        return studentDao.selectById(id);
    }
}
