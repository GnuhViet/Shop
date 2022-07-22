package com.example.shopbanhang.dao.service;

import com.example.shopbanhang.dao.ProductDao;
import com.example.shopbanhang.dao.impl.ProductDaoImpl;
import com.example.shopbanhang.model.Product;

import java.util.List;

public class ProductService  {
    private final static ProductDaoImpl productDao = new ProductDaoImpl();

    public static String create(Product product) {
        return productDao.create(product);
    }

    public static String update(Product product) {
        return productDao.update(product);
    }

    public static String updateRating(int id, int rating) {
        return productDao.updateRating(id, rating);
    }

    public static Product read(int id) {
        return productDao.read(id);
    }

    public static void delete(int id) {
        productDao.delete(id);
    }

    public static int getTotalProduct(String name) {
        return productDao.getTotalProduct(name);
    }

    public static int getTotalProduct() {
        return productDao.getTotalProduct("");
    }

    public static List<Product> getInRange(int start, int total, String name) {
        return productDao.getInRange(start, total, name);
    }

    public static List<Product> getInRange(int start, int total) {
        return productDao.getInRange(start, total, "");
    }
}
