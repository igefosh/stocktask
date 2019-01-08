package com.igefosh.dao;

import com.igefosh.entity.User;
import com.igefosh.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public User getById(int id) {
        String sql = "SELECT * FROM product WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }


    public void save(User user) {
        String sql = "INSERT INTO product (name, email, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());
    }

    public void update(User user) {
        String sql = "UPDATE product SET name=?, email=?, age=? WHERE id=?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM product WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new UserMapper());
    }
}
