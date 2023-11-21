<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/public/images/favico.svg" type="image/svg+xml">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/profile.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <title>Octotung - Seu Perfil</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <%@ page import="com.hug.web.entities.*" %>
    <main>
        <h1>My Profile</h1>
        <div class="profile-content">
            <div class="left-content">
                <h3>${user.firstName} ${user.lastName}</h3>
                <p>Email: ${user.email}</p>
                <p>CPF: ${user.cpf}</p>
            </div>
            <div class="right-content">
                <c:if test="${user.isOrganizer}">
                    <p>Account Type:</p>
                    <p>You are a organizer</p>
                </c:if>
                <c:if test="${user.isOrganizer == false}">
                    <p>Account Type:</p>
                    <p>You are not a organizer</p>
                </c:if>
                <p>Phone: ${user.phone}</p>
                <p>Age: ${UserDAO.calculateAgeByEmail(user.email)}</p>
            </div>
        </div>
        <div class="tickets-owned-content">
            <c:forEach var="currentTicket" items="${ticketsList}">
            <div class="ticket-container">
                <div class="container-header">
                    <p>${currentTicket.name}</p>
                    <p>Evento ${currentTicket.type}</p>
                </div>
                <div class="container-main">
                    <div class="content-side">
                        <p>${currentTicket.location}</p>
                    </div>
                    <div class="date-side">
                        <p>${currentTicket.eventDate}</p>
                        <p>${currentTicket.eventTime}</p>
                    </div>
                </div>
                <p>Organizador: ${UserDAO.getNameById(EventDAO.getOrganizerId(currentTicket.eventId))}</p>
            </div>
        </c:forEach>
        </div>
    </main>
    <%@ include file="footer.jsp" %>
</body>
</html>