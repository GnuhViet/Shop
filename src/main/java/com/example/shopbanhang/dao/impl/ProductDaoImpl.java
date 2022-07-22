package com.example.shopbanhang.dao.impl;

import com.example.shopbanhang.dao.MySQL;
import com.example.shopbanhang.dao.ProductDao;
import com.example.shopbanhang.model.Product;
import com.example.shopbanhang.model.User;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    private Connection con;
    private PreparedStatement pre;
    private ResultSet rs;

    public ProductDaoImpl() {
        con = MySQL.getConnection();
        pre = null;
        rs = null;
    }

    @Override
    public String create(Product product) {
        try {
            String sql = "INSERT INTO product VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pre = con.prepareStatement(sql);
            pre.setInt(1, product.getId());
            pre.setString(2, product.getType());
            pre.setString(3, product.getName());
            pre.setString(4, product.getGender());
            pre.setBigDecimal(5, product.getPrice());
            pre.setBigDecimal(6, product.getRating());
            pre.setBigDecimal(7, product.getRating());
            pre.setString(8, product.getBrand());
            pre.setString(9, product.getDescription());
            pre.setString(10, product.getColor());
            pre.setString(11, product.getSpecification());
            pre.setString(12, product.getSize());
            pre.setString(13, product.getImage());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return "failed";
        } finally {
            try { pre.close(); } catch (SQLException ignore){}
        }
        return "successfully";
    }

    @Override
    public String update(Product product) {
        try {
            String sql = "UPDATE product SET type = ?, name = ?, gender = ?, price = ?, brand = ?, description = ?, color =  ?, specification = ?, size = ?, image = ? where id = ?";
            pre = con.prepareStatement(sql);
            pre.setInt(11, product.getId());
            pre.setString(1, product.getType());
            pre.setString(2, product.getName());
            pre.setString(3, product.getGender());
            pre.setBigDecimal(4, product.getPrice());
            pre.setString(5, product.getBrand());
            pre.setString(6, product.getDescription());
            pre.setString(7, product.getColor());
            pre.setString(8, product.getSpecification());
            pre.setString(9, product.getSize());
            pre.setString(10, product.getImage());
            pre.executeUpdate();
        } catch (SQLException e) {
            return "failed";
        } finally {
            try { pre.close(); } catch (SQLException ignore){}
        }
        return "successfully";
    }

    @Override
    public String updateRating(int id, int rating) {
        if (rating > 5 || rating < 1) {
            return "only in range (1-5)";
        }

        Product product = read(id);
        double rate = (product.getRating().doubleValue() * product.getRatingCounter() + rating )/(product.getRatingCounter() + 1);
        BigDecimal r = BigDecimal.valueOf(rate);

        try {
            String sql = "UPDATE product SET rating = ? , rating_counter = ? where id = ?";
            pre = con.prepareStatement(sql);
            pre.setInt(3, id);
            pre.setBigDecimal(1, r);
            pre.setInt(2, product.getRatingCounter() + 1);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return "failed";
        } finally {
            try { pre.close(); } catch (SQLException ignore){}
        }
        return "successfully";
    }

    @Override
    public Product read(int id) {
        try {
            String sql = "SELECT * FROM product WHERE id = ?";
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
    public void delete(int id) {
        try {
            String sql = "DELETE FROM product WHERE id = ?";
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
    public int getTotalProduct(String name) {
        try {
            String sql = "SELECT COUNT(*) FROM product WHERE name LIKE ?";
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

    @Override
    public List<Product> getInRange(int start, int total, String name) {
        List<Product> products = null;
        try {
            String sql = "SELECT * FROM product WHERE name LIKE ? LIMIT ?, ?";
            pre = con.prepareStatement(sql);
            pre.setString(1, name + "%");
            pre.setInt(2, start);
            pre.setInt(3, total);
            rs = pre.executeQuery();
            products = new ArrayList<Product>();
            while (rs.next()) {
                products.add(rowMap(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { pre.close(); rs.close(); } catch (SQLException ignore){}
        }
        return products;
    }

    private Product rowMap(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setType(rs.getString("type"));
        product.setName(rs.getString("name"));
        product.setGender(rs.getString("gender"));
        product.setPrice(String.valueOf(rs.getBigDecimal("price")) + "$");
        product.setRating(rs.getDouble("rating"));
        product.setRatingCounter(rs.getInt("rating_counter"));
        product.setBrand(rs.getString("brand"));
        product.setDescription(rs.getString("description"));
        product.setColor(rs.getString("color"));
        product.setSpecification(rs.getString("specification"));
        product.setSize(rs.getString("size"));
        product.setImage(rs.getString("image"));
        return product;
    }
}
