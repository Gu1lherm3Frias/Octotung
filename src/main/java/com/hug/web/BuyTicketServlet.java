package com.hug.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import com.hug.web.entities.EventDAO;
import com.hug.web.entities.TicketDAO;
import com.hug.web.entities.UserDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/buyTicket")
public class BuyTicketServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String eventId = req.getParameter("id");
        String eventName = req.getParameter("name");
        String eventType = req.getParameter("type");
        String location = req.getParameter("location");
        String eventDate = req.getParameter("eventDate");
        String eventTime = req.getParameter("eventTime");
        Integer organizerId = EventDAO.getOrganizerId(eventName);

        HttpSession session = req.getSession();
        String userEmail = (String) session.getAttribute("userEmail");

        try {
            LocalDate formattedDate = LocalDate.parse(eventDate);
            Date castedDate = Date.valueOf(formattedDate);
            LocalTime formattedTime = LocalTime.parse(eventTime);
            Time castedTime = Time.valueOf(formattedTime);
            TicketDAO.createNewTicket(eventName, castedDate, castedTime, location, eventType, UserDAO.getUserIdByEmail(userEmail), Integer.valueOf(eventId), organizerId);
            res.sendRedirect("profile");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }    
}
