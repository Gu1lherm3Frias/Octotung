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
    @NotBlank
    private String phone;
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

    
    public RegisterForm(String firstname, String lastname, String cpf, String phone, String email, String password, String confirmPassword) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.CPF = cpf;
        this.phone = phone;
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
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    

}
