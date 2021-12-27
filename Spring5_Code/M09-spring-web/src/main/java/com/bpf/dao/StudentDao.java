package com.bpf.dao;

import com.bpf.bean.Student;
import org.apache.ibatis.annotations.Param;

public interface StudentDao {

    int insertStudent(Student student);

    Student selectById(@Param("id") Integer id);
}
