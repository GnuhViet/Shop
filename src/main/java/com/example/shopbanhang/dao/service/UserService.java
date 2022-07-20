package com.example.shopbanhang.dao.service;

import com.example.shopbanhang.dao.MySQL;
import com.example.shopbanhang.dao.UserDao;
import com.example.shopbanhang.dao.impl.UserDaoImpl;
import com.example.shopbanhang.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserDao userDao = new UserDaoImpl();

    public static String add(User user) {
        return userDao.add(user);
    }

    public static void update(User user) {
        userDao.update(user);
    }

    public static void delete(int id) {
        userDao.delete(id);
    }

    public static void updateLoginCounter(int id, int counter) {
        userDao.updateLoginCounter(id, counter);
    }

    public static User get(int id) {
        return userDao.get(id);
    }

    public static User getByUsername(String username)  {
        return userDao.getByUsername(username);
    }

    public static List<User> search(String name) {
        return userDao.search(name);
    }

    public static List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public static int getTotalUser() {
        return userDao.getTotalUser();
    }

    public static List<User> getUserInRange(int start, int total) {
        return userDao.getInRange(start, total);
    }
}
