package com.hug.web.forms;

import java.sql.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class RegisterForm {
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private String CPF;
    @NotNull
    @Past
    private Date bornDate;
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
    @NotNull
    private Boolean isOrganizer;
    
    public RegisterForm(@NotNull @NotBlank String firstName, @NotNull @NotBlank String lastName,
            @NotNull @NotBlank String cPF, @NotNull @Past Date bornDate, @NotNull @NotBlank String phone,
            @NotNull @NotBlank @Email String email, @NotNull @NotEmpty @Size(min = 8, max = 20) String password,
            @NotNull @NotEmpty @Size(min = 8, max = 20) String confirmPassword, @NotNull Boolean isOrganizer) {
        this.firstName = firstName;
        this.lastName = lastName;
        CPF = cPF;
        this.bornDate = bornDate;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.isOrganizer = isOrganizer;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Boolean getIsOrganizer() {
        return isOrganizer;
    }

    public void setIsOrganizer(Boolean isOrganizer) {
        this.isOrganizer = isOrganizer;
    }

    
}
