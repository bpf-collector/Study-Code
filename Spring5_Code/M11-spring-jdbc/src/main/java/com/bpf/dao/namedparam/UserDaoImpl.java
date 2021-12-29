package com.bpf.dao.namedparam;

import com.bpf.bean.User;
import com.bpf.dao.UserDao;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("userDapImplNamedParam")
public class UserDaoImpl implements UserDao {

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * 保存用户，返回影响的行数
     *
     * @param user
     * @return
     */
    @Override
    public Integer insert(User user) {
        String sql = "insert into user(u_name,u_pwd) values(:name, :pwd)";

        /**
         * public int update(String sql, Map<String, ?> paramMap)
         *      需要手动组装 Map 对象数据
         */
        Map<String, Object> map = new HashMap<>();
        map.put("name", user.getUsername());
        map.put("pwd", user.getPassword());
        // return namedParameterJdbcTemplate.update(sql, map);

        /**
         * public int update(String sql, SqlParameterSource paramSource)
         *      BeanPropertySqlParameterSource 使用时需要注意命名的参数需与对象的属性名相同！
         */
        sql = "insert into user(u_name,u_pwd) values(:username, :password)";
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
    }

    /**
     * 保存用户，返回主键
     *
     * @param user
     * @return
     */
    @Override
    public Integer insertAndReturnKey(User user) {
        String sql = "insert into user(u_name,u_pwd) values(:username, :password)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        /**
         * public int update(String sql, SqlParameterSource paramSource, KeyHolder generatedKeyHolder)
         */
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user), keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     * 根据用户ID更新用户信息
     *
     * @param user
     * @return
     */
    @Override
    public Integer update(User user) {
        String sql = "update user set u_name=:username,u_pwd=:password where u_id=:id";
        return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
    }

    /**
     * 根据用户ID删除
     *
     * @param id
     * @return
     */
    @Override
    public Integer delete(Integer id) {
        String sql = "delete from user where u_id=:id";
        // 只有一对 key:value 时可以直接使用 MapSqlParameterSource(String, Object)
        return namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
    }

    /**
     * 统计用户总记录
     *
     * @return
     */
    @Override
    public Integer count() {
        String sql = "select count(1) from user";
        // EmptySqlParameterSource 对应空参数
        return namedParameterJdbcTemplate.queryForObject(sql, new EmptySqlParameterSource(), Integer.class);
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
        return null;
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
