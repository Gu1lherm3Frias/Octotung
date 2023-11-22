<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/public/images/favico.svg" type="image/svg+xml">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/register.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <title><fmt:message key="register.title"/></title>
</head>
<body>
    <div class="register-container">
        <div class="form-container">
            <div class="form-container-block">
                <div class="form-container-header">
                    <a href="index">
                        <svg id="arrow-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><!--! Font Awesome Pro 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M9.4 233.4c-12.5 12.5-12.5 32.8 0 45.3l160 160c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L109.2 288 416 288c17.7 0 32-14.3 32-32s-14.3-32-32-32l-306.7 0L214.6 118.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0l-160 160z"/></svg>
                    </a>
                    <h2><fmt:message key="register.title"/></h2>
                    <p><fmt:message key="register.subtitle"/></p>
                </div>
                <form class="register-form" action="register" method="POST">
                    <div class="column">
                        <div class="input-box">
                            <label for="firstname"><fmt:message key="register.form.firstname"/></label>
                            <input type="text" id="firstname" name="firstname" value="${form.firstName}">
                        </div>
                        <div class="input-box">
                            <label for="lastname"><fmt:message key="register.form.lastname"/></label>
                            <input type="text" id="lastname" name="lastname" value="${form.lastName}">
                        </div>
                    </div>
                    
                    <div class="column">
                        <div class="input-box">
                            <label for="cpf"><fmt:message key="register.form.CPF"/></label>
                            <input type="text" name="cpf"  pattern="(\d{3}\.?\d{3}\.?\d{3}-?\d{2})">
                        </div>
                        <div class="input-box">
                            <label for="born-date"><fmt:message key="register.form.borndate"/></label>
                            <input type="date" id="born-date" name="born-date">
                        </div>
                    </div>
                    <div class="column">
                        <div class="input-box">
                            <label for="phone"><fmt:message key="register.form.phone"/></label>
                            <input type="tel" id="phone" name="phone">
                        </div>
                        <div class="select-box">
                            <label for="user-type"><fmt:message key="register.form.user-type"/></label>
                            <select name="user-type" id="user-type">
                                <option value="" disabled selected></option>
                                <option value="false"><fmt:message key="register.form.user-type.user"/></option>
                                <option value="true"><fmt:message key="register.form.user-type.organizer"/></option>
                            </select>
                        </div>
                    </div>
                    <div class="input-box">
                        <label for="email"><fmt:message key="register.form.email"/></label>
                        <input type="email" id="email" name="email" value="${form.email}">
                    </div>
                    <div class="input-box">
                        <label for="password"><fmt:message key="register.form.password"/></label>
                        <input type="password" id="password" name="password">
                    </div>
                    <div class="input-box">
                        <label for="confirm-password"><fmt:message key="register.form.password-confirm"/></label>
                        <input type="password" id="confirm-password" name="confirm-password">
                    </div>
                    <button type="submit"><fmt:message key="register.form.button"/></button>
                </form>
                <div class="form-container-footer">
                    <p><fmt:message key="register.p.login"/><a class="alt-links" href="login"><fmt:message key="register.link.login"/></a></p>
                </div>
            </div>
        </div>
    </div>
</body>
</html>