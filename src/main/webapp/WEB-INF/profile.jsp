<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <title>Octotung - <fmt:message key="profile.title"/></title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <%@ page import="com.hug.web.entities.*" %>
    <main>
        <div class="profile-title">
            <h1><fmt:message key="profile.title"/></h1>
        </div>
        <div class="profile-container">
            <div class="content-header">
                <h3>${user.firstName} ${user.lastName}</h3>
                <div class="account-info">
                    <c:if test="${user.isOrganizer}">
                        <p class="label-custom"><fmt:message key="profile.user.acc-type"/></p>
                        <p class="account-type-info"><fmt:message key="profile.user.acc.organizer-type"/></p>
                    </c:if>
                    <c:if test="${user.isOrganizer == false}">
                        <p class="label-custom"><fmt:message key="profile.user.acc-type"/></p>
                        <p class="account-type-info"><fmt:message key="profile.user.acc.user-type"/></p>
                    </c:if>
                </div>
            </div>
            <div class="content-main">
                <div class="content-main-header">
                    <div>
                        <p class="label-custom"><fmt:message key="profile.user.email"/></p>
                        <p>${user.email}</p>
                    </div>
                    <div>
                        <p class="label-custom"><fmt:message key="profile.user.CPF"/></p>
                        <p>${user.cpf}</p>
                    </div>
                </div>
                <div class="content-main-footer">
                    <div>
                        <p class="label-custom"><fmt:message key="profile.user.phone"/></p>
                        <p>${user.phone}</p>
                    </div>
                    <div class="user-age">
                        <p class="label-custom"><fmt:message key="profile.user.age"/></p>
                        <p>${UserDAO.calculateAgeByEmail(user.email)}</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="tickets-owned-content">
            <h2><fmt:message key="profile.ticket.title"/></h2>
            <c:forEach var="currentTicket" items="${ticketsList}">
                <div class="ticket-container">
                    <div class="ticket-container-header">
                        <div class="content-side">
                            <p class="ticket-name">${currentTicket.ticketName}</p>
                            <p class="ticket-id">${currentTicket.id}</p>
                        </div>
                        <div class="date-side">
                            <p>${currentTicket.ticketDate}</p>
                            <p><fmt:message key="profile.ticket.event-time.p"/> ${currentTicket.ticketTime}</p>
                        </div>
                    </div>
                    <div class="ticket-container-footer">
                        <p>${currentTicket.location}</p>
                        <p><fmt:message key="profile.ticket.event-type.p"/> ${currentTicket.type}</p>
                    </div>
                </div>
            </c:forEach>
            <div class="buy-tickets-button">
                <a href="events"><fmt:message key="profile.ticket.button"/></a>
            </div>
        </div>
    </main>
    <%@ include file="footer.jsp" %>
</body>
</html>