package com.example.shopbanhang.controller;

import com.example.shopbanhang.dao.UserDao;
import com.example.shopbanhang.dao.impl.UserDaoImpl;
import com.example.shopbanhang.dao.service.UserService;
import com.example.shopbanhang.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User u = UserService.getByUsername(username);

        HttpSession session = req.getSession();

        if (u == null) {
            resp.sendRedirect("view/login.jsp?status=not-exist");
            return;
        }

        if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
            session.setAttribute("username", username);
            resp.sendRedirect("index.jsp");
        } else {
            resp.sendRedirect("view/login.jsp?status=not-correct");
        }
    }
}
