package com.hug.web.forms;

import java.sql.Date;
import java.sql.Time;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CreateEventForm {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @Future
    private Date date;
    @NotNull
    @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$", message = "Formato de tempo inválido")
    private Time eventTime;
    @NotNull
    @NotBlank
    private String location;
    @NotNull
    @NotBlank
    private String type;

    public CreateEventForm(@NotNull @NotBlank String name, @NotNull @NotBlank String description,
            @NotNull @Future Date date,
            @NotNull @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$", message = "Formato de tempo inválido") Time eventTime,
            @NotNull @NotBlank String location, @NotNull @NotBlank String type) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.eventTime = eventTime;
        this.location = location;
        this.type = type;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
