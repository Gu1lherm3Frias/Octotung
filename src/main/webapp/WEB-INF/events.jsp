<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/public/images/favico.svg" type="image/svg+xml">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/events.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <title>Octotung - Eventos</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <%@ page import="com.hug.web.entities.*" %>
    <main>
        <div class="events-title">
            <h1><fmt:message key="events.title.h1"/></h1>
        </div>
        <c:forEach var="currentEvent" items="${eventsList}">
            <div class="event-container">
                <div class="container-header">
                    <h2 class="event-name">${currentEvent.name}</h2>
                    <p class="event-type"><fmt:message key="event.event-type.p"/> ${currentEvent.type}</p>
                </div>
                <div class="container-main">
                    <div class="content-side">
                        <p class="event-description">${currentEvent.description}</p>
                        <p class="event-location">${currentEvent.location}</p>
                    </div>
                    <div class="date-side">
                        <p>${currentEvent.eventDate}</p>
                        <p><fmt:message key="event.event-time.p"/> ${currentEvent.eventTime}</p>
                    </div>
                </div>
                <div class="container-footer">
                    <div class="organizer-content">    
                        <p><fmt:message key="event.organizer"/></p>
                        <p>${UserDAO.getNameById(EventDAO.getOrganizerId(currentEvent.name))}</p>
                    </div>
                    <div class="buy-ticket-button">
                        <a class="alt-links" href="buyTicket?id=${currentEvent.id}&name=${currentEvent.name}&type=${currentEvent.type}&location=${currentEvent.location}&eventDate=${currentEvent.eventDate}&eventTime=${currentEvent.eventTime}"><fmt:message key="event.buy-ticket.button"/></a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </main>
    <%@ include file="footer.jsp" %>
</body>
</html>