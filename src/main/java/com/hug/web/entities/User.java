package com.hug.web.entities;

import java.util.Date;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String cpf;
    private String borndate;
    private String email;
    private String password;

    public User(Integer id, String firstName, String lastName, String cpf, String borndate, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.borndate = borndate;
        this.email = email;
        this.password = password;
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

    public String getBorndate() {
        return borndate;
    }

    public void setBorndate(String borndate) {
        this.borndate = borndate;
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


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }    
}
