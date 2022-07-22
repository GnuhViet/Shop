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
    public String create(User user) {
        try {
            String sql = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?)";
            pre = con.prepareStatement(sql);
            pre.setInt(1, user.getId());
            pre.setString(2, user.getName());
            pre.setInt(3, user.getAge());
            pre.setString(4, user.getGender());
            pre.setString(5, user.getPhone());
            pre.setString(6, user.getAddress());
            pre.setString(7, user.getCountry());
            pre.setString(8, user.getRegion());
            pre.setString(9, user.getEmail());
            pre.setString(10, user.getUsername());
            pre.setString(11, user.getPassword());
            pre.setString(12, user.getRole());
            pre.setString(13, user.getImage());
            pre.setInt(14, user.getLoginCounter());
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
            String sql = "UPDATE user SET name = ?, age = ?, gender = ?, phone = ?, address = ?, country = ?, region = ?, email = ?, username = ?, password = ?, role = ?, image = ?, login_counter = ? WHERE id = ?";
            pre = con.prepareStatement(sql);
            pre.setInt   (14, user.getId());
            pre.setString(1, user.getName());
            pre.setInt   (2, user.getAge());
            pre.setString(3, user.getGender());
            pre.setString(4, user.getPhone());
            pre.setString(5, user.getAddress());
            pre.setString(6, user.getCountry());
            pre.setString(7, user.getRegion());
            pre.setString(8, user.getEmail());
            pre.setString(9, user.getUsername());
            pre.setString(10, user.getPassword());
            pre.setString(11, user.getRole());
            pre.setString(12, user.getImage());
            pre.setInt   (13, user.getLoginCounter());
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
    public User read(int id) {
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
    public int getTotalUser(String name) {
        try {
            String sql = "SELECT COUNT(*) FROM user WHERE name LIKE ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, name + "%");
            rs = pre.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { pre.close(); rs.close(); } catch (SQLException ignore){}
        }
        return 0;
    }

    public List<User> getInRange(int start, int total, String name){
        List<User> users = null;
        try {
            String sql = "SELECT * FROM user WHERE name LIKE ? LIMIT ?, ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, name + "%");
            pre.setInt(2, start);
            pre.setInt(3, total);
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
        user.setPhone(rs.getString("phone"));
        user.setAddress(rs.getString("address"));
        user.setCountry(rs.getString("country"));
        user.setRegion(rs.getString("region"));
        user.setEmail(rs.getString("email"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        user.setImage(rs.getString("image"));
        user.setLoginCounter(rs.getInt("login_counter"));
        return user;
    }
}
