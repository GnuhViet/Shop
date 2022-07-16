package com.example.shopbanhang.dao;

import com.example.shopbanhang.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void add(User user);
    void update(User user);
    void delete(int id);
    void updateLoginCounter(int id, int counter);
    User get(int id);
    User getByUsername(String username) throws SQLException;
    List<User> search(String name);
}
