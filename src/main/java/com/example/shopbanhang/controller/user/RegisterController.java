package com.example.shopbanhang.controller.user;

import com.example.shopbanhang.dao.service.UserService;
import com.example.shopbanhang.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole("member");
        user.setImage("none.jpg");
        String status = UserService.add(user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/register.jsp?status=" + status);
        dispatcher.forward(req, resp);
    }
}
