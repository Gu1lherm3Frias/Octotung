<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <h1>Aqui estão os melhores eventos</h1>
        </div>
        <c:forEach var="currentEvent" items="${eventsList}">
            <div class="event-container">
                <div class="container-header">
                    <p>${currentEvent.name}</p>
                    <p>Evento ${currentEvent.type}</p>
                </div>
                <div class="container-main">
                    <div class="content-side">
                        <p>${currentEvent.description}</p>
                        <p>${currentEvent.location}</p>
                    </div>
                    <div class="date-side">
                        <p>${currentEvent.eventDate}</p>
                        <p>${currentEvent.eventTime}</p>
                    </div>
                </div>
                <p>Organizador: ${UserDAO.getNameById(EventDAO.getOrganizerId(currentEvent.id))}</p>
                <button type="submit">Buy Ticket</button>
            </div>
        </c:forEach>
    </main>
    <%@ include file="footer.jsp" %>
</body>
</html>