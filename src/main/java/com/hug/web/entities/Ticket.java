package com.hug.web.entities;

import java.sql.Date;
import java.sql.Time;

public class Ticket {
    private String id;
    private String ticketName;
    private Date ticketDate;
    private Time ticketTime;
    private String location;
    private String type;

    public Ticket(String id, String ticketName, Date ticketDate, Time ticketTime, String location, String type) {
        this.id = id;
        this.ticketName = ticketName;
        this.ticketDate = ticketDate;
        this.ticketTime = ticketTime;
        this.location = location;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public Time getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(Time ticketTime) {
        this.ticketTime = ticketTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}