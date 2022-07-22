package com.example.shopbanhang.controller.user;

import com.example.shopbanhang.dao.service.UserService;
import com.example.shopbanhang.model.User;

import javax.servlet.RequestDispatcher;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User u = UserService.getByUsername(username);

        HttpSession session = req.getSession();

        if (u == null) {
            resp.sendRedirect("/ShopBanHang/login?status=not-exist");
            return;
        }

        if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
            session.setAttribute("user", u);

            resp.sendRedirect("/ShopBanHang/home");
        } else {
            resp.sendRedirect("/ShopBanHang/login?status=not-correct");
        }
    }
}
