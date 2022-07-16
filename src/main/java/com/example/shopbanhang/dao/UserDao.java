package com.example.shopbanhang.dao;

import com.example.shopbanhang.model.User;

import java.util.List;

public interface UserDao {
    String add(User user);
    void update(User user);
    void delete(int id);
    void updateLoginCounter(int id, int counter);
    User get(int id);
    User getByUsername(String username);
    List<User> search(String name);
}
