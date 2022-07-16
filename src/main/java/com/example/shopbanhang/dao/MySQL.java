package com.example.shopbanhang.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQL {
    public static final String DRIVER_PATH = "com.mysql.cj.jdbc.Driver";
    public static final String username = "root";
    public static final String password = "";
    public static final String url = "jdbc:mysql://localhost:3306/MyShop?createDatabaseIfNotExist=true&useUnicode=yes&characterEncoding=UTF-8";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_PATH);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("MySQL connect failed");
        }
        return null;
    }
}
