package com.example.shopbanhang.dao;

import com.example.shopbanhang.model.Product;

import java.util.List;

public interface ProductDao {
    String create(Product product);
    String update(Product product);
    String updateRating(int id, int rating);
    Product read(int id);
    void delete(int id);
    int getTotalProduct(String name);
    List<Product> getInRange(int start, int total, String name);
}
