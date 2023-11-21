package com.hug.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import com.hug.web.entities.EventDAO;
import com.hug.web.entities.User;
import com.hug.web.entities.UserDAO;
import com.hug.web.forms.CreateEventForm;
import com.hug.web.validators.ValidatorUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolation;

@WebServlet(name = "createEvent", value = "/createEvent")
public class CreateEventServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userEmail = (String) session.getAttribute("userEmail");
        User user = UserDAO.findByEmail(userEmail);
        req.setAttribute("user", user);
        req.getRequestDispatcher("WEB-INF/create-event.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String eventName = req.getParameter("event-name");
        String eventDescription = req.getParameter("description");
        String eventDate = req.getParameter("event-date");
        String eventTime = req.getParameter("event-time");
        String eventlocation = req.getParameter("event-location");
        String eventType = req.getParameter("event-type");

        HttpSession session = req.getSession(); 
        String organizerEmail = (String) session.getAttribute("userEmail");
        Integer organizerId = UserDAO.getUserIdByEmail(organizerEmail);

        try {
            LocalDate formattedDate = LocalDate.parse(eventDate);
            Date castedDate = Date.valueOf(formattedDate);
            LocalTime formattedTime = LocalTime.parse(eventTime);
            Time castedTime = Time.valueOf(formattedTime);

            CreateEventForm form = new CreateEventForm(eventName, eventDescription, castedDate, castedTime, eventlocation, eventType);
            Set<ConstraintViolation<CreateEventForm>> violations = ValidatorUtil.validateObject(form);

            if (!violations.isEmpty()) {
                ConstraintViolation<CreateEventForm> firstViolation = violations.iterator().next();
                String errorMessage = firstViolation.getMessage();
                req.setAttribute("create-event-error-violation", errorMessage);
                req.setAttribute("form", form);
                req.getRequestDispatcher("WEB-INF/create-event.jsp").forward(req, res);
            }else {
                EventDAO.createNewEvent(eventName, eventDescription, castedDate, castedTime, eventlocation, eventType, organizerId);
                res.sendRedirect("events");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
