package com.example.shopbanhang.controller;

import com.example.shopbanhang.dao.service.UserService;
import com.example.shopbanhang.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/profile"})
@MultipartConfig(
        fileSizeThreshold = 1024*1024,
        maxFileSize = 1024*1024*9,
        maxRequestSize = 1024*1024*10
)
public class ProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object obj = req.getSession().getAttribute("username");
        if (obj == null) {
            resp.sendRedirect("login");
            return;
        }
        String status = req.getParameter("status");
        if (status != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/profile.jsp?status=" + status);
            dispatcher.forward(req, resp);
            return;
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/profile.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object obj = req.getSession().getAttribute("username");

        if (obj == null) {
            resp.sendRedirect("login");
            return;
        }

        String username = String.valueOf(obj);
        User user = UserService.getByUsername(username);
        user.setName(req.getParameter("name"));
        System.out.println(req.getParameter("age"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        user.setGender(req.getParameter("gender"));
        user.setPhone(req.getParameter("phone"));
        user.setAddress(req.getParameter("address"));
        user.setEmail(req.getParameter("email"));
        user.setCountry(req.getParameter("country"));
        user.setRegion(req.getParameter("region"));

        UserService.update(user);
        resp.sendRedirect("profile?status=successfully");
    }
}
