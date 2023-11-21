package com.hug.web;

import java.io.IOException;
import java.util.List;

import com.hug.web.entities.Event;
import com.hug.web.entities.EventDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "events", value = "/events")
public class EventsServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Event> events = EventDAO.showAll();
        req.setAttribute("eventsList", events);
        req.getRequestDispatcher("WEB-INF/events.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
