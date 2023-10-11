package com.hug.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name= "loginServlet", value="/loginServlet")
public class LoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        List<String> errors = new ArrayList<>();

        if (email == null || email.isBlank())
            errors.add("E-mail is empty");
        if (password == null || password.isEmpty())
            errors.add("Password is empty");
        if (email != null && !email.contains("@"))
            errors.add("Invalid E-mail");
        if (password != null && (password.length() < 8 || password.length() > 20))
            errors.add("Password must have a minimum of 8 characters and max 20");
        if (password != null) {
            Boolean containLowerCase = false;
            Boolean containUpperCase = false;
            Boolean containDigits = false;

            for (char c : password.toCharArray()) {
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

        if (errors.isEmpty()) {
            res.sendRedirect("index.jsp");
        }else {
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("login.jsp").forward(req, res);
        }
    }
}
