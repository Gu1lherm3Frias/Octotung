package com.hug.web;

import java.io.IOException;
import java.util.Set;

import com.hug.web.entities.UserDAO;
import com.hug.web.forms.LoginForm;
import com.hug.web.validators.ValidatorUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;

@WebServlet(name= "loginServlet", value="/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, res);

    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        LoginForm form = new LoginForm(email, password);

        Set<ConstraintViolation<LoginForm>> violations = ValidatorUtil.validateObject(form);

        if (violations.isEmpty()) {
            if (UserDAO.doLogin(email, password)) {
                HttpSession session = req.getSession();
                session.setAttribute("userEmail", email);
                res.sendRedirect("index");
            }else {
                req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, res);
            }
        }else {
            req.setAttribute("form", form);
            req.setAttribute("violations", violations);
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, res);
        }
    }
}
