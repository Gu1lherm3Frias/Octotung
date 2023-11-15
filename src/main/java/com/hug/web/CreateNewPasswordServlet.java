package com.hug.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "createNewPassword", value = "/createNewPassword")
public class CreateNewPasswordServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/create-new-password.jsp").forward(req, res);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String newPassword = req.getParameter("new-password");
        String confirmNewPassword = req.getParameter("confirm-new-password");

        List<String> errors = new ArrayList<>();

        if (newPassword == null || newPassword.isEmpty())
            errors.add("Password is empty");
        if (confirmNewPassword == null || confirmNewPassword.isEmpty())
            errors.add("Confirm password is empty");
        if (newPassword != null && (newPassword.length() < 8 || newPassword.length() > 20))
            errors.add("Password must have a minimum of 8 characters and max 20");
        if (confirmNewPassword != null && (confirmNewPassword.length() < 8 || confirmNewPassword.length() > 20))
            errors.add("Password must have a minimum of 8 characters and max 20");
        if (newPassword != null) {
            Boolean containLowerCase = false;
            Boolean containUpperCase = false;
            Boolean containDigits = false;

            for (char c : newPassword.toCharArray()) {
                if (Character.isLowerCase(c))
                    containLowerCase = true;
                if (Character.isUpperCase(c))
                    containUpperCase = true;
                if (Character.isDigit(c))
                    containDigits = true;
            }

            if (!containLowerCase)
                errors.add("Password must have 1 Lowercase character");
            if (!containUpperCase) 
                errors.add("Password must have 1 Uppercase character");
            if (!containDigits)
                errors.add("Password must have digits");
        }

        if (confirmNewPassword != null) {
            Boolean containLowerCase = false;
            Boolean containUpperCase = false;
            Boolean containDigits = false;

            for (char c : confirmNewPassword.toCharArray()) {
                if (Character.isLowerCase(c))
                    containLowerCase = true;
                if (Character.isUpperCase(c))
                    containUpperCase = true;
                if (Character.isDigit(c))
                    containDigits = true;
            }

            if (!containLowerCase)
                errors.add("Password must have 1 Lowercase character");
            if (!containUpperCase) 
                errors.add("Password must have 1 Uppercase character");
            if (!containDigits)
                errors.add("Password must have digits");
        }

        if (!confirmNewPassword.equals(newPassword))
            errors.add("Password doesn't match");

        if (errors.isEmpty()) {
            res.sendRedirect("login.jsp");
        }else {
            req.setAttribute("new-password", newPassword);
            req.setAttribute("confirm-new-password", confirmNewPassword);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("create-new-pswd.jsp").forward(req, res);
        }
    } 
    
}