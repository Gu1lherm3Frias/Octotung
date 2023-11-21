package com.hug.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.Set;

import com.hug.web.entities.UserDAO;
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
        String firstName = req.getParameter("firstname"); 
        String lastName = req.getParameter("lastname");
        String CPF = req.getParameter("cpf");
        String bornDate = req.getParameter("born-date");
        String phone = req.getParameter("phone"); 
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirm-password");
        Boolean isOrganizer = Boolean.parseBoolean(req.getParameter("user-type"));

        Boolean errorCheck = false;
        
        try {
            LocalDate formatedDate = LocalDate.parse(bornDate);
            Date castDate = Date.valueOf(formatedDate);
            RegisterForm form = new RegisterForm(firstName, lastName, CPF, castDate, phone, email, password, confirmPassword, isOrganizer);
            Set<ConstraintViolation<RegisterForm>> violations = ValidatorUtil.validateObject(form);
            
            if (!violations.isEmpty()) {
                ConstraintViolation<RegisterForm> firstViolation = violations.iterator().next();
                String errorMessage = firstViolation.getMessage();
                req.setAttribute("register-error-violation", errorMessage);
                errorCheck = true;
            }else {
                if (UserDAO.emailAlreadyExists(email)) {
                    req.setAttribute("register-error", "register.emailAlreadyExist");
                    errorCheck = true;
                }else if (UserDAO.CPFAlreadyExists(CPF)) {
                    req.setAttribute("register-error", "register.CPFAlreadyExist");
                    errorCheck = true;
                }else if (!password.equals(confirmPassword)) {
                    req.setAttribute("register-error", "register.passwordDoesNotMatch");
                    errorCheck = true;
                }
            }    
                
            if  (errorCheck) {
                req.setAttribute("form", form);
                req.getRequestDispatcher("WEB-INF/register.jsp").forward(req, res);
            }else {
                UserDAO.addNewUser(firstName, lastName, CPF, castDate, phone, email, password, isOrganizer);
                res.sendRedirect("login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
