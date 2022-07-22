package com.example.shopbanhang.controller.user;

import com.example.shopbanhang.dao.service.UserService;
import com.example.shopbanhang.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet(urlPatterns = {"/profile"})
@MultipartConfig(
        location = "E:\\ShopBanHangFileUploads\\tmp",
        fileSizeThreshold = 1024*1024*2,
        maxFileSize = 1024*1024*19,
        maxRequestSize = 1024*1024*20
)

public class ProfileController extends HttpServlet {
    private static final String UPLOAD_PATH = "E:\\ShopBanHangFileUploads\\UserImage";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object obj = req.getSession().getAttribute("user");
        if (obj == null) {
            resp.sendRedirect("/ShopBanHang/login");
            return;
        }

        String status = req.getParameter("status");
        if (status != null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/profile.jsp?status=" + status);
            dispatcher.forward(req, resp);
            return;
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/profile.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object obj = req.getSession().getAttribute("user");

        if (obj == null) {
            resp.sendRedirect("/ShopBanHang/login");
            return;
        }

        User user = (User) obj;
        user.setName(req.getParameter("name"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        user.setGender(req.getParameter("gender"));
        user.setPhone(req.getParameter("phone"));
        user.setAddress(req.getParameter("address"));
        user.setEmail(req.getParameter("email"));
        user.setCountry(req.getParameter("country"));
        user.setRegion(req.getParameter("region"));
        user.setImage(saveAndGetFileName(req, user.getId()));

        UserService.update(user);
        resp.sendRedirect("/ShopBanHang/profile?status=successfully");
    }


    private String saveAndGetFileName(HttpServletRequest req, int userId) throws ServletException, IOException {
        Part filePart = req.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); //MSIE fix

        if ("".equals(fileName)) {
            return null;
        }

        File uploads = new File(UPLOAD_PATH);

        if(!uploads.exists()) {
            uploads.mkdir();
        }

        File image = new File(uploads, "user" + userId + "Image" + ".jpg");
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, image.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        return image.getName();
    }
}
