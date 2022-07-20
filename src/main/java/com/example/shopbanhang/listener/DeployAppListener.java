package com.example.shopbanhang.listener;

import com.example.shopbanhang.dao.MySQL;
import com.example.shopbanhang.dao.UserDao;
import com.example.shopbanhang.dao.impl.UserDaoImpl;
import com.example.shopbanhang.model.User;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebListener
public class DeployAppListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserDao dao = new UserDaoImpl();
        Connection con = MySQL.getConnection();
        Statement st = null;

        String userTableCreate = "CREATE TABLE IF NOT EXISTS USER (\n" +
                "    id int(11) NOT NULL AUTO_INCREMENT,\n" +
                "    name varchar(45) DEFAULT NULL,\n" +
                "    age int(11) DEFAULT NULL,\n" +
                "    gender varchar(10) DEFAULT NULL,\n" +
                "    phone varchar(15) DEFAULT NULL,\n" +
                "    address varchar(100) DEFAULT NULL,\n" +
                "    country varchar(30) DEFAULT NULL,\n" +
                "    region varchar(100) DEFAULT NULL,\n" +
                "    email varchar(100) DEFAULT NULL,\n" +
                "    username varchar(45) DEFAULT NULL,\n" +
                "    password varchar(45) DEFAULT NULL,\n" +
                "    role varchar(45) DEFAULT NULL,\n" +
                "    image text DEFAULT NULL,\n" +
                "    login_counter int(11) DEFAULT 0,\n" +
                "    CONSTRAINT PK_USER PRIMARY KEY (id),\n" +
                "    CONSTRAINT UC_USER UNIQUE (username)\n" +
                ");";
        String categoryTableCreate = "CREATE TABLE IF NOT EXISTS category (\n" +
                "    id int(11) NOT NULL AUTO_INCREMENT,\n" +
                "    name varchar(45) NOT NULL,\n" +
                "    gender varchar(10) DEFAULT NULL,\n" +
                "    price decimal(4,2) NOT NULL,\n" +
                "    rating int(2) NOT NULL,\n" +
                "    brand varchar(45) DEFAULT NULL,\n" +
                "    description text DEFAULT NULL,\n" +
                "    color text NOT NULL,\n" +
                "    specification text NOT NULL,\n" +
                "    size text NOT NULL,\n" +
                "    image text NOT NULL,\n" +
                "    CONSTRAINT PK_CATEGORY PRIMARY KEY (id)\n" +
                ")";

        try {
            st = con.createStatement();
            st.executeUpdate(userTableCreate);
            st.executeUpdate(categoryTableCreate);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { st.close(); } catch (SQLException ignore){}
        }

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setRole("admin");
        admin.setImage("none.jpg");

        dao.add(admin);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        String sqlUserDrop = "DROP TABLE USER;";
        String databaseDrop = "DROP DATABASE myshop";
        try {
            Connection con = MySQL.getConnection();
            Statement st = con.createStatement();
            //st.executeUpdate(sqlUserDrop);
            //st.executeUpdate(databaseDrop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
