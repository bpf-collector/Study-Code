package com.bpf.dao;

import com.bpf.bean.Good;

public interface GoodDao {

    Good selectById(Integer id);

    int updateGood(Good good);
}
