package com.bpf.dao.simple;

import com.bpf.bean.User;
import com.bpf.dao.UserDao;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository("userDaoImplSimpleInsert")
public class UserDaoImpl implements UserDao, InitializingBean {

    @Resource
    private SimpleJdbcInsert jdbcInsert;

    /**
     * Bean 的初始化方法，进行 SimpleJdbcInsert 的通用配置
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // 指定操作哪个表，若此处不指定，需在每处使用时都指定
        jdbcInsert.withTableName("user");

        // 配置代操作的列名
        // jdbcInsert.usingColumns("u_id", "u_name", "u_pwd");
    }

    /**
     * 保存用户，返回影响的行数
     *
     * @param user
     * @return
     */
    @Override
    public Integer insert(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("u_name", user.getUsername());
        map.put("u_pwd", user.getPassword());
        return jdbcInsert.execute(map);

        // 使用 BeanPropertySqlParameterSource 需要数据表列名与属性名相同！
        // return jdbcInsert.execute(new BeanPropertySqlParameterSource(user));
    }

    /**
     * 保存用户，返回主键
     *
     * @param user
     * @return
     */
    @Override
    public Integer insertAndReturnKey(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("u_name", user.getUsername());
        map.put("u_pwd", user.getPassword());
        return jdbcInsert.usingGeneratedKeyColumns("u_id").executeAndReturnKey(map).intValue();
    }

    /**
     * 根据用户ID更新用户信息
     *
     * @param user
     * @return
     */
    @Override
    public Integer update(User user) {
        return null;
    }

    /**
     * 根据用户ID删除
     *
     * @param id
     * @return
     */
    @Override
    public Integer delete(Integer id) {
        return null;
    }

    /**
     * 统计用户总记录
     *
     * @return
     */
    @Override
    public Integer count() {
        return null;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> selectUsers() {
        return null;
    }

    /**
     * 根据ID查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User selectById(Integer id) {
        return null;
    }

    /**
     * 批量保存用户，返回影响的行数
     *
     * @param list
     * @return
     */
    @Override
    public Integer batchInsert(List<User> list) {

        List<Map<String, Object>> collect = list.stream().map(user -> {
            Map<String, Object> map = new HashMap<>();
            map.put("u_name", user.getUsername());
            map.put("u_pwd", user.getPassword());
            return map;
        }).collect(Collectors.toList());

        Map<String, Object>[] maps = collect.toArray(new Map[collect.size()]);
        return Arrays.stream(jdbcInsert.executeBatch(maps)).sum();

        // 数据表列名与属性名相同才能这样用：
        // return Arrays.stream(jdbcInsert.executeBatch(SqlParameterSourceUtils.createBatch(list))).sum();
    }

    /**
     * 批量更新用户信息，返回影响的行数
     *
     * @param list
     * @return
     */
    @Override
    public Integer batchUpdate(List<User> list) {
        return null;
    }

    /**
     * 批量删除用户，返回影响的行数
     *
     * @param list
     * @return
     */
    @Override
    public Integer batchDelete(List<Integer> list) {
        return null;
    }
}
