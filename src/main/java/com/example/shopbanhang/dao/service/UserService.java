package com.example.shopbanhang.dao.service;

import com.example.shopbanhang.dao.UserDao;
import com.example.shopbanhang.dao.impl.UserDaoImpl;
import com.example.shopbanhang.model.User;

import java.util.List;

public class UserService {
    private static UserDao userDao = new UserDaoImpl();

    public static String add(User user) {
        return userDao.create(user);
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
        return userDao.read(id);
    }

    public static User getByUsername(String username)  {
        return userDao.getByUsername(username);
    }

    public static int getTotalUser() {
        return userDao.getTotalUser("");
    }

    public static int getTotalUser(String name) {
        return userDao.getTotalUser(name);
    }

    public static List<User> getUserInRange(int start, int total) {
        return userDao.getInRange(start, total, "");
    }

    public static List<User> getUserInRange(int start, int total, String name) {
        return userDao.getInRange(start, total, name);
    }

}
