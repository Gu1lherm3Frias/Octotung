package com.hug.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "passwordRecovery", value = "/passwordRecovery")
public class PasswordRecoveryServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.getRequestDispatcher("WEB-INF/password-recovery.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String email = req.getParameter("email");

        List<String> errors = new ArrayList<>();

        if (email == null || email.isBlank())
            errors.add("E-mail is empty");
        if (email != null && !email.contains("@"))
            errors.add("Invalid e-mail");

        if (errors.isEmpty())
            res.sendRedirect("recovery-code.jsp");
        else {
            req.setAttribute("email", email);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("password-recovery.jsp").forward(req, res);
        } 

    }
}
