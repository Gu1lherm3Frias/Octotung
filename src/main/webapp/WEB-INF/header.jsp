<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/header.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
</head>
<body>
    <div class="header">
        <header class="header-nav">
            <a href="index">
                <img src="${pageContext.request.contextPath}/resources/public/images/logo.svg" alt="logo">
            </a>
            <nav class="nav-links">
                <a href="events"><fmt:message key="header.nav.event"/></a>
                <a href="createEvent"><fmt:message key="header.nav.create-event"/></a>
                <a href="aboutUs"><fmt:message key="header.nav.about-us"/></a>
            </nav>
            <div class="login-button">
                <a href="login"><fmt:message key="header.header.login"/></a>
            </div>
        </header>
    </div>
</body>
</html>
