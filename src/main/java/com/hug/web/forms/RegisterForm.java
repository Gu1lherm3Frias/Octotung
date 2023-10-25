package com.hug.web.forms;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class RegisterForm {
    @NotNull
    @NotBlank
    private String firstname;
    @NotNull
    @NotBlank
    private String lastname;
    @NotNull
    @NotBlank
    private String CPF;
    @NotNull
    @Past
    private Date borndate;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 20)
    private String password;
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 20)
    private String confirmPassword;

    
    public RegisterForm(  String firstname, String lastname, String cpf, Date borndate, String email, String password, String confirmPassword) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.CPF = cpf;
        this.borndate = borndate;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getCPF() {
        return CPF;
    }
    public void setCPF(String cpf) {
        CPF = cpf;
    }
    public Date getBorndate() {
        return borndate;
    }
    public void setBorndate(Date borndate) {
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
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    

}
