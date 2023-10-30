package com.hug.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import com.hug.web.forms.RegisterForm;
import com.hug.web.validators.ValidatorUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
    
@WebServlet(name= "register", value="/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/register.jsp").forward(req, res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String firstname = req.getParameter("firstname"); 
        String lastname = req.getParameter("lastname");
        String CPF = req.getParameter("CPF");
        String borndate = req.getParameter("born-date"); 
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");

        RegisterForm form = new RegisterForm(firstname, lastname, CPF, borndate, email, password, confirmPassword);
        
        Set<ConstraintViolation<RegisterForm>> violations = ValidatorUtil.validateObject(form);
        if (violations.isEmpty()) {
            res.sendRedirect("login.jsp");
        }else {
            req.setAttribute("form", form);
            req.setAttribute("violations", violations);
            req.getRequestDispatcher("WEB-INF/register.jsp").forward(req, res);
        }
        
    }
}
