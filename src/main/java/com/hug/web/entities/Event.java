package com.hug.web.entities;

import java.sql.Date;
import java.sql.Time;

public class Event {
    private Integer id;
    private String name;
    private String description;
    private Date eventDate;
    private Time eventTime;
    private String location;
    private String type;
    
    public Event(String name, String description, Date eventDate, Time eventTime, String location, String type) {
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.location = location;
        this.type = type;
    }

    public Event(Integer id, String name, String description, Date eventDate, Time eventTime, String location, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.location = location;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Time getEventTime() {
        return eventTime;
    }

    public void setEventTime(Time eventTime) {
        this.eventTime = eventTime;
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
