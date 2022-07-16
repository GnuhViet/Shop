package com.example.shopbanhang.listener;

import com.example.shopbanhang.dao.MySQL;

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
        String sqlUserCreate = "CREATE TABLE IF NOT EXISTS USER (\n" +
                "    id int(11) NOT NULL AUTO_INCREMENT,\n" +
                "    name varchar(45) DEFAULT NULL,\n" +
                "    age int(11) DEFAULT NULL,\n" +
                "    gender varchar(10) DEFAULT NULL,\n" +
                "    username varchar(45) DEFAULT NULL,\n" +
                "    password varchar(45) DEFAULT NULL,\n" +
                "    role varchar(45) DEFAULT NULL,\n" +
                "    image text DEFAULT NULL,\n" +
                "    login_counter int(11) DEFAULT 0,\n" +
                "    CONSTRAINT PK_USER PRIMARY KEY (id),\n" +
                "    CONSTRAINT UC_USER UNIQUE (username)\n" +
                ");";
        try {
            Connection con = MySQL.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate(sqlUserCreate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        String sqlUserDrop = "DROP TABLE USER;";
        try {
            Connection con = MySQL.getConnection();
            Statement st = con.createStatement();
            st.executeUpdate(sqlUserDrop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
