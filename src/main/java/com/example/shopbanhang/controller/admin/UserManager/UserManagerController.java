package com.example.shopbanhang.controller.admin.UserManager;

import com.example.shopbanhang.dao.service.UserService;
import com.example.shopbanhang.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/user"})
public class UserManagerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("table", "user");

        final int USER_PER_PAGE = 11;

        int totalUser = 0;

        String searchName = req.getParameter("search");
        if (searchName != null) {
            totalUser = UserService.getTotalUser(searchName);
        } else {
            totalUser = UserService.getTotalUser();
        }

        int totalPages = totalUser / USER_PER_PAGE + 1;

        int currentPage = 0;
        String viewPage = req.getParameter("page");
        if (viewPage != null) {
            currentPage = Integer.parseInt(req.getParameter("page")) - 1;
        }

        int startIndex = currentPage * USER_PER_PAGE;

        List<User> users = null;
        int lastPage = totalUser;
        if (searchName != null) {
            if (currentPage == totalPages - 1) {
                lastPage = totalUser % USER_PER_PAGE;
                users = UserService.getUserInRange(startIndex, lastPage, searchName);
            } else {
                users = UserService.getUserInRange(startIndex, USER_PER_PAGE, searchName);
            }
        } else {
            if (currentPage == totalPages - 1) {
                lastPage = totalUser % USER_PER_PAGE;
                users = UserService.getUserInRange(startIndex, lastPage);
            } else {
                users = UserService.getUserInRange(startIndex, USER_PER_PAGE);
            }
        }

        if (searchName != null) {
            req.setAttribute("search", searchName);
        }
        req.setAttribute("userPerPage", Math.min(Math.min(totalUser, lastPage), USER_PER_PAGE));

        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", currentPage + 1);
        req.setAttribute("startIndex", startIndex);
        req.setAttribute("totalUsers", totalUser);
        req.setAttribute("users", users);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/admin.jsp");
        dispatcher.forward(req, resp);
    }
}
