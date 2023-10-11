package com.hug.web;

import jakarta.servlet.http.*;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("funcionou");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        getServletContext().getRequestDispatcher("/home").forward(req, res);
    }
}