<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/public/images/favico.svg" type="image/svg+xml">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/login.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <title><fmt:message key="login.title"/></title>
</head>
<body>
    <div class="login-container">
        <div class="form-container">
            <div class="form-container-block">
                <a href="index">
                    <svg id="arrow-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><!--! Font Awesome Pro 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M9.4 233.4c-12.5 12.5-12.5 32.8 0 45.3l160 160c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L109.2 288 416 288c17.7 0 32-14.3 32-32s-14.3-32-32-32l-306.7 0L214.6 118.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0l-160 160z"/></svg>
                </a>
                <h2><fmt:message key="login.title"/></h2>
                <p><fmt:message key="login.subtitle"/></p>
                <form class="login-form" action="login" method="POST">
                    <label for="email"><fmt:message key="login.email.label"/></label>
                    <input type="email" id="email" name="email" value="${email}">
                    <label for="password"><fmt:message key="login.password.label"/></label>
                    <input type="password" id="password" name="password">
                    <p><fmt:message key="login.forgot-password.p"/><a class="alt-links" href="passwordRecovery"><fmt:message key="login.forgot-password.a"/></a></p>
                    <button type="submit"><fmt:message key="login.submit.button"/></button>
                </form>
                <p><fmt:message key="login.new-account.p"/><a class="alt-links" href="register"><fmt:message key="login.new-account.a"/></a></p>
            </div>
        </div>
    </div>
</body>
</html>