<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/footer.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
</head>
<body>
    <div class="footer">
        <div class="support-social-media">
            <div class="social-media">
                <p><fmt:message key="footer.social-networks.p"/></p>
                <nav>
                    <a href="https://github.com/gu1lherm3frias/octotung" target="_blank"><fmt:message key="footer.social-networks.nav.github"/></a>
                    <a href="" target="_blank"><fmt:message key="footer.social-networks.nav.discord"/></a>
                    <a href="" target="_blank"><fmt:message key="footer.social-networks.nav.twitter"/></a>
                    <a href="" target="_blank"><fmt:message key="footer.social-networks.nav.instagram"/></a>
                </nav>
            </div>
            <div class="support-content">
                <p><fmt:message key="footer.support-contacts.p"/></p>
                <a href=""><fmt:message key="footer.support-contact.email"/></p></a>
            </div>
        </div>
        <div class="sub-footer">
            <a href="index">
                <img src="${pageContext.request.contextPath}/resources/public/images/logo.svg" alt="logo">
            </a>
            <div class="signup-button">
                <a href="register"><fmt:message key="footer.signup.button"/></a>
            </div>
        </div>
    </div>
</body>
</html>