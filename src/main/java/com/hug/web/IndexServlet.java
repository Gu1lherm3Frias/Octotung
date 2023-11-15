package com.hug.web;

import jakarta.servlet.http.*;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;

@WebServlet(name = "indexServlet", value = {"/index", "/"})
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, res);
    }
}