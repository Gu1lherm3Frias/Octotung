package com.hug.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.xalan.xsltc.compiler.util.ErrorMsg;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name= "signUpServlet", value="/signUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userName = req.getParameter("username"); 
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");
        
        List<String> errors = new ArrayList<>();

        if (userName == null || userName.isBlank())
            errors.add("Name is empty");
        if (email == null || email.isBlank())
            errors.add("E-mail is empty");
        if (password == null || password.isEmpty())
            errors.add("Password is empty");
        if (confirmPassword == null || confirmPassword.isEmpty())
            errors.add("Confirm password is empty");
        if (email != null && !email.contains("@"))
            errors.add("Invalid E-mail");
        if (password != null && (password.length() < 8 || password.length() > 20))
            errors.add("Password must have a minimum of 8 characters and max 20");
        if (confirmPassword != null && (confirmPassword.length() < 8 || confirmPassword.length() > 20))
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

        if (confirmPassword != null) {
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

        if (!confirmPassword.equals(password))
            errors.add("Password doesn't match");

        if (errors.isEmpty()) {
            res.sendRedirect("login.jsp");
        }else {
            req.setAttribute("username", userName);
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("confirm-password", confirmPassword);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("signup.jsp").forward(req, res);
        }
    }
}
