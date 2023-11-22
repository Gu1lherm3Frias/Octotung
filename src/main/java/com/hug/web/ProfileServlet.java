package com.hug.web;

import java.io.IOException;
import java.util.List;

import com.hug.web.entities.UserDAO;
import com.hug.web.entities.Ticket;
import com.hug.web.entities.TicketDAO;
import com.hug.web.entities.User;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "profileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userEmail = (String) session.getAttribute("userEmail");
        
        User user = UserDAO.findByEmail(userEmail);
        req.setAttribute("user", user);

        List<Ticket> tickets = TicketDAO.getTicketsByUserId(UserDAO.getUserIdByEmail(userEmail));
        req.setAttribute("ticketsList", tickets);

        req.getRequestDispatcher("WEB-INF/profile.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
