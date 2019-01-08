package com.igefosh.dao;

import com.igefosh.entity.User;

import java.util.List;

public interface UserDao {

    User getById(int id);

    void save (User user);

    void update (User user);

    void delete (int id);

    List<User> findAll();

}
