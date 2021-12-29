package com.bpf.dao;

import com.bpf.bean.User;

import java.util.List;

public interface UserDao {

    /**
     * 保存用户，返回影响的行数
     * @param user
     * @return
     */
    Integer insert(User user);

    /**
     * 保存用户，返回主键
     * @param user
     * @return
     */
    Integer insertAndReturnKey(User user);

    /**
     * 根据用户ID更新用户信息
     * @param user
     * @return
     */
    Integer update(User user);

    /**
     * 根据用户ID删除
     * @param id
     * @return
     */
    Integer delete(Integer id);

    /**
     * 统计用户总记录
     * @return
     */
    Integer count();

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> selectUsers();

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 批量保存用户，返回影响的行数
     * @param list
     * @return
     */
    Integer batchInsert(List<User> list);

    /**
     * 批量更新用户信息，返回影响的行数
     * @param list
     * @return
     */
    Integer batchUpdate(List<User> list);

    /**
     * 批量删除用户，返回影响的行数
     * @param list
     * @return
     */
    Integer batchDelete(List<Integer> list);
}
