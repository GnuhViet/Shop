package com.example.shopbanhang.dao.impl;

import com.example.shopbanhang.dao.MySQL;
import com.example.shopbanhang.dao.UserDao;
import com.example.shopbanhang.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection con;
    private PreparedStatement pre;
    private ResultSet rs;

    public UserDaoImpl() {
       con = MySQL.getConnection();
       pre = null;
       rs = null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void updateLoginCounter(int id, int counter) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        try {
            String sql = "SELECT * FROM user WHERE username = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, username);
            rs = pre.executeQuery();
            while (rs.next()) {
                return rowMap(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pre.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }

    @Override
    public List<User> search(String name) {
        return null;
    }

    private User rowMap(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setGender(rs.getString("gender"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        user.setImage(rs.getString("image"));
        user.setLoginCounter(rs.getInt("login_counter"));
        return user;
    }
}
