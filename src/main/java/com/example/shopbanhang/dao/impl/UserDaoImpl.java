package com.example.shopbanhang.dao.impl;

import com.example.shopbanhang.dao.MySQL;
import com.example.shopbanhang.dao.UserDao;
import com.example.shopbanhang.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public String add(User user) {
        try {
            String sql = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ? ,?, ?)";
            pre = con.prepareStatement(sql);
            pre.setInt(1, user.getId());
            pre.setString(2, user.getName());
            pre.setInt(3, user.getAge());
            pre.setString(4, user.getGender());
            pre.setString(5, user.getUsername());
            pre.setString(6, user.getPassword());
            pre.setString(7, user.getRole());
            pre.setString(8, user.getImage());
            pre.setInt(9, user.getLoginCounter());
            pre.executeUpdate();
        } catch (SQLException e) {
            return "failed";
        } finally {
            try { pre.close(); } catch (SQLException ignore){}
        }
        return "successfully";
    }

    @Override
    public void update(User user) {
        try {
            String sql = "UPDATE user SET name = ?, age = ?, gender = ?, username = ?, password = ?, role = ?, image = ?, login_counter = ? WHERE id = ?";
            pre = con.prepareStatement(sql);
            pre.setInt   (9, user.getId());
            pre.setString(1, user.getName());
            pre.setInt   (2, user.getAge());
            pre.setString(3, user.getGender());
            pre.setString(4, user.getUsername());
            pre.setString(5, user.getPassword());
            pre.setString(6, user.getRole());
            pre.setString(7, user.getImage());
            pre.setInt   (8, user.getLoginCounter());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { pre.close(); } catch (SQLException ignore){}
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM USER WHERE id = ?";
            pre = con.prepareStatement(sql);
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { pre.close(); } catch (SQLException ignore){}
        }
    }

    @Override
    public void updateLoginCounter(int id, int counter) {
        try {
            String sql = "UPDATE user SET login_counter = ? WHERE id = ?";
            pre = con.prepareStatement(sql);
            pre.setInt(1, counter);
            pre.setInt(2, id);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { pre.close(); } catch (SQLException ignore){}
        }
    }

    @Override
    public User get(int id) {
        try {
            String sql = "SELECT * FROM user WHERE id = ?";
            pre = con.prepareStatement(sql);
            pre.setInt(1, id);
            rs = pre.executeQuery();
            while (rs.next()) {
                return rowMap(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { pre.close(); rs.close(); } catch (SQLException ignore){}
        }
        return null;
    }

    @Override
    public User getByUsername(String username) {
        try {
            String sql = "SELECT * FROM user WHERE username = ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, username);
            rs = pre.executeQuery();
            if (rs.next()) {
                return rowMap(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { pre.close(); rs.close(); } catch (SQLException ignore){}
        }
        return null;
    }

    @Override
    public List<User> search(String name) {
        List<User> users = null;
        try {
            String sql = "SELECT * FROM user WHERE name like ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, name + "%");
            rs = pre.executeQuery();
            users = new ArrayList<User>();
            while (rs.next()) {
                users.add(rowMap(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { pre.close(); rs.close(); } catch (SQLException ignore){}
        }
        return users;
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
