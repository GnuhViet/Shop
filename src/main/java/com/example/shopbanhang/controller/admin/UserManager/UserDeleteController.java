package com.example.shopbanhang.controller.admin.UserManager;

import com.example.shopbanhang.dao.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin/user/remove"})
public class UserDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/ShopBanHang/admin");
    }
}
