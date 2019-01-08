package com.igefosh.service;

import com.igefosh.entity.User;

import java.util.List;

public interface UserService {

    User getById(int id);

    void save (User user);

    void update (User user);

    void delete (int id);

    List<User> findAll();
}
