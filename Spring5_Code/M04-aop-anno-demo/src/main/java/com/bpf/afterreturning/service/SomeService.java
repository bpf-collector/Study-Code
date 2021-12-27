package com.bpf.afterreturning.service;

import com.bpf.afterreturning.bean.Person;

public interface SomeService {

    String doSome(String msg);

    Person doGet(String name, Integer age);
}
