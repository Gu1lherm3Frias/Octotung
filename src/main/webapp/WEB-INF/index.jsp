<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/public/images/favico.svg" type="image/svg+xml">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/home.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <title>Octotung - <fmt:message key="home.title"/></title>
</head>
<body>
    <div class="app-container">
        <%@ include file="header.jsp" %>
        <main>
            <div class="main">
                <div class="hero">
                    <h1><fmt:message key="home.hero.title"/></h1>
                    <p><fmt:message key="home.hero.subtitle.message"/></p>
                    <div class="event-hero-button">
                        <a href="events"><fmt:message key="home.hero.button"/></a>
                    </div>
                </div>
            </div>
            <div class="section-ticket">
                <div class="section-text-content">    
                    <h2><fmt:message key="ticket.session.title"/></h2>
                    <p><fmt:message key="ticket.session.message"/></p>
                    <p><fmt:message key="ticket.session.submessage"/></p>
                    <div class="buy-tickets-button">
                        <a href="events"><fmt:message key="ticket.session.button"/></a>
                    </div>
                </div>
                <img src="${pageContext.request.contextPath}/resources/public/images/tickets.svg" alt="">
            </div>
            <div class="section-search">
                <div class="section-text-content">
                    <h2><fmt:message key="subsection.session.title"/></h2>
                    <p><fmt:message key="subsection.session.message"/></p>
                    <p><fmt:message key="subsection.session.submessage"/></p>
                </div>
                <img src="${pageContext.request.contextPath}/resources/public/images/search-in-notebook.svg" alt="">
            </div>
        </main>
        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>