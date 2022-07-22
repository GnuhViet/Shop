package com.example.shopbanhang.dao;

import com.example.shopbanhang.model.User;

import java.util.List;

public interface UserDao {
    String create(User user);
    void update(User user);
    User read(int id);
    void delete(int id);
    void updateLoginCounter(int id, int counter);
    User getByUsername(String username);
    int getTotalUser(String name);
    List<User> getInRange(int start, int total, String name);
}
