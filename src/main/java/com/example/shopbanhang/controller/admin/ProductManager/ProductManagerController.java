package com.example.shopbanhang.controller.admin.ProductManager;

import com.example.shopbanhang.dao.service.ProductService;
import com.example.shopbanhang.dao.service.UserService;
import com.example.shopbanhang.model.Product;
import com.example.shopbanhang.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin/product"})
public class ProductManagerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("table", "product");

        final int PRODUCT_PER_PAGE = 11;

        int totalProduct = 0;

        String searchName = req.getParameter("search");
        if (searchName != null) {
            totalProduct = ProductService.getTotalProduct(searchName);
        } else {
            totalProduct = ProductService.getTotalProduct();
        }

        int totalPages = totalProduct / PRODUCT_PER_PAGE + 1;

        int currentPage = 0;
        String viewPage = req.getParameter("page");
        if (viewPage != null) {
            currentPage = Integer.parseInt(req.getParameter("page")) - 1;
        }

        int startIndex = currentPage * PRODUCT_PER_PAGE;

        List<Product> products = null;
        int lastPage = totalProduct;
        if (searchName != null) {
            if (currentPage == totalPages - 1) {
                lastPage = totalProduct % PRODUCT_PER_PAGE;
                products = ProductService.getInRange(startIndex, lastPage, searchName);
            } else {
                products = ProductService.getInRange(startIndex, PRODUCT_PER_PAGE, searchName);
            }
        } else {
            if (currentPage == totalPages - 1) {
                lastPage = totalProduct % PRODUCT_PER_PAGE;
                products = ProductService.getInRange(startIndex, lastPage);
            } else {
                products = ProductService.getInRange(startIndex, PRODUCT_PER_PAGE);
            }
        }
        System.out.println(products);

        if (searchName != null) {
            req.setAttribute("search", searchName);
        }
        req.setAttribute("userPerPage", Math.min(Math.min(totalProduct, lastPage), PRODUCT_PER_PAGE));

        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", currentPage + 1);
        req.setAttribute("startIndex", startIndex);
        req.setAttribute("totalUsers", totalProduct);
        req.setAttribute("products", products);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/admin.jsp");
        dispatcher.forward(req, resp);
    }
}
