package com.hug.web.entities;

import java.sql.Date;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String cpf;
    private Date bornDate;
    private String phone;
    private String email;
    private String password;
    private Boolean isOrganizer;

    public User(String firstName, String lastName, String cpf, Date bornDate, String phone, String email, String password, Boolean isOrganizer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.bornDate = bornDate;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.isOrganizer = isOrganizer;
    }

    public User(Integer id, String firstName, String lastName, String cpf, Date bornDate, String phone, String email, String password, Boolean isOrganizer) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.bornDate = bornDate;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.isOrganizer = isOrganizer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBorndate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsOrganizer() {
        return isOrganizer;
    }

    public void setIsOrganizer(Boolean isOrganizer) {
        this.isOrganizer = isOrganizer;
    }    
}
