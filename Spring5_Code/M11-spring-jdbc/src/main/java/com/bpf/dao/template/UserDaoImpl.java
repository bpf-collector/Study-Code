package com.bpf.dao.template;

import com.bpf.bean.User;
import com.bpf.dao.UserDao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("userDaoImplTemplate")
public class UserDaoImpl implements UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 保存用户，返回影响的行数
     *
     * @param user
     * @return
     */
    @Override
    public Integer insert(User user) {
        return jdbcTemplate.update("insert into user(u_name, u_pwd) values(?, ?)",
                user.getUsername(), user.getPassword());
    }

    /**
     * 保存用户，返回主键
     *
     * @param user
     * @return
     */
    @Override
    public Integer insertAndReturnKey(User user) {
        // 使用 KeyHolder 的唯一实现类 GeneratedKeyHolder
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        // 方法第一个参数: PreparedStatementCreator 是一个函数式接口，参数是 Connection, 返回值是 PreparedStatement
        // 方法第二个参数: KeyHolder. 方法执行后会将主键值放在 keyHolder 中
        jdbcTemplate.update(conn -> {
            Statement statement = conn.createStatement();
            PreparedStatement ps = conn.prepareStatement("insert into user(u_name, u_pwd) values(?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            return ps;
        }, keyHolder);

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
        String sql = "update user set u_name = ?, u_pwd = ? where u_id = ?";

        // public int update(String sql, @Nullable Object... args)
        // return jdbcTemplate.update(sql,
        //         //         user.getUsername(), user.getPassword(), user.getId());

        /**
         * public int update(String sql, @Nullable PreparedStatementSetter pss)
         *      函数式接口 PreparedStatementSetter
         *      void setValues(PreparedStatement ps)
         */
        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setInt(3, user.getId());
            }
        });

        /**
         * PreparedStatementSetter 的实现类: ArgumentTypePreparedStatementSetter
         */
        // return jdbcTemplate.update(sql, new ArgumentTypePreparedStatementSetter(
        //         new Object[] {user.getUsername(), user.getPassword(), user.getId()},
        //         new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER}));

        /**
         * PreparedStatementSetter 的实现类: ArgumentPreparedStatementSetter
         */
        // return jdbcTemplate.update(sql, new ArgumentPreparedStatementSetter(
        //         new Object[] {user.getUsername(), user.getPassword(), user.getId()}));
    }

    /**
     * 根据用户ID删除
     *
     * @param id
     * @return
     */
    @Override
    public Integer delete(Integer id) {
        return jdbcTemplate.update("delete from user where u_id = ?", id);
    }

    /**
     * 统计用户总记录
     *
     * @return
     */
    @Override
    public Integer count() {
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> selectUsers() {
        String sql = "select u_id,u_name,u_pwd from user";

        /**
         * public <T> List<T> queryForList(String sql, Class<T> elementType)
         *   看似查询 {@Code List<T>} 但其实只能查询一列值，然后将这一列值封装为 List。
         *   因为底层使用的是 SingleColumnRowMapper(), 真的只能存储一列值
         */
        // 错误！
        // return jdbcTemplate.queryForList(sql, User.class);


        /**
         * 获取 {@Code List<?>} 方法一：函数式接口 ResultSetExtractor
         *
         * <T> T query(String sql, ResultSetExtractor<T> rse, @Nullable Object... args) throws DataAccessException;
         *      T extractData(ResultSet rs) throws SQLException, DataAccessException;
         */
        // return jdbcTemplate.query(sql, new ResultSetExtractor<List<User>>() {
        //     @Override
        //     public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
        //         List<User> userList = new ArrayList<>();
        //         while (rs.next()) {
        //             User user = new User();
        //             user.setId(rs.getInt("u_id"));
        //             user.setUsername(rs.getString("u_name"));
        //             user.setPassword(rs.getString("u_pwd"));
        //             userList.add(user);
        //         }
        //         return userList;
        //     }
        // });

        /**
         * 获取 {@Code List<?>} 方法二：函数式接口 RowCallbackHandler
         *
         * void query(String sql, RowCallbackHandler rch, @Nullable Object... args) throws DataAccessException;
         *      void processRow(ResultSet rs) throws SQLException;
         */
        // List<User> userList = new ArrayList<>();
        // jdbcTemplate.query(sql, new RowCallbackHandler() {
        //     @Override
        //     public void processRow(ResultSet rs) throws SQLException {
        //         User user = new User();
        //         user.setId(rs.getInt("u_id"));
        //         user.setUsername(rs.getString("u_name"));
        //         user.setPassword(rs.getString("u_pwd"));
        //         userList.add(user);
        //     }
        // });
        // return userList;


        /**
         * 获取 {@Code List<?>} 方法三：函数式接口 RowMapper
         *
         * <T> List<T> query(String sql, RowMapper<T> rowMapper, @Nullable Object... args) throws DataAccessException;
         *      T mapRow(ResultSet rs, int rowNum) throws SQLException;
         */
        // return jdbcTemplate.query(sql, new UserRowMapper());

        // 使用 BeanPropertyRowMapper 时需要注意列名需要与属性名相同才能对应上
        sql = "select u_id id, u_name username, u_pwd password from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    /**
     * 根据ID查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User selectById(Integer id) {
        String sql = "select u_id,u_name,u_pwd from user where u_id = ?";

        /**
         * public <T> T queryForObject(String sql, Class<T> requiredType, @Nullable Object... args)
         *   看似查询 {@Code T} 但其实只能查询一列值，然后将这一列值封装为 T。
         *   因为底层使用的是 SingleColumnRowMapper(), 真的只能存储一列值
         */
        // 错误！
        // return jdbcTemplate.queryForObject(sql, User.class, id);

        // public <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args) throws DataAccessException
        // 此处也可使用 BeanPropertyRowMapper
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
    }

    /**
     * 批量保存用户，返回影响的行数
     *
     * @param list
     * @return
     */
    @Override
    public Integer batchInsert(List<User> list) {
        String sql = "insert into user(u_name,u_pwd) values(?,?)";
        return Arrays.stream(jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                User user = list.get(i);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
            }

            @Override
            public int getBatchSize() {
                return list.size();
            }
        })).sum();
    }

    /**
     * 批量更新用户信息，返回影响的行数
     *
     * @param list
     * @return
     */
    @Override
    public Integer batchUpdate(List<User> list) {
        String sql = "update user set u_name=?,u_pwd=? where u_id=?";
        return Arrays.stream(jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                User user = list.get(i);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setInt(3, user.getId());
            }

            @Override
            public int getBatchSize() {
                return list.size();
            }
        })).sum();
    }

    /**
     * 批量删除用户，返回影响的行数
     *
     * @param list
     * @return
     */
    @Override
    public Integer batchDelete(List<Integer> list) {
        String sql = "delete from user where u_id = ?";
        return Arrays.stream(jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, list.get(i));
            }

            @Override
            public int getBatchSize() {
                return list.size();
            }
        })).sum();
    }

    public static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("u_id"));
            user.setUsername(rs.getString("u_name"));
            user.setPassword(rs.getString("u_pwd"));
            return user;
        }
    }
}
