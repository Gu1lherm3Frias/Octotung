<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/public/images/favico.svg" type="image/svg+xml">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/global.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/make-event.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <title>Octotung - Criar Evento</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <main>
        <div class="form-container-block">
            <div class="form-container-header">
                <h2><fmt:message key="create-event.title"/></h2>
                <p><fmt:message key="create-event.subtitle"/></p>
            </div>
            <form class="create-event-form" action="createEvent" method="POST">
                <div class="input-box">
                    <label for="event-name"><fmt:message key="create-event.form.name"/></label>
                    <input type="text" id="event-name" name="event-name"/>
                </div>
                <div class="input-box">
                    <label for="description"><fmt:message key="create-event.form.description"/></label>
                    <textarea id="description" name="description"></textarea>
                </div>
                <div class="input-box">
                    <label for="event-date"><fmt:message key="create-event.form.event-date"/></label>
                    <input type="date" id="event-date" name="event-date">
                </div>
                <div class="input-box">
                    <label for="event-time"><fmt:message key="create-event.form.event-time"/></label>
                    <input type="time" id="event-time" name="event-time">
                </div>
                <div class="input-box">
                    <label for="event-location"><fmt:message key="create-event.form.event-location"/></label>
                    <input type="text" id="event-location" name="event-location">
                </div>
                <div class="select-box">
                    <label for="event-type"><fmt:message key="create-event.form.event-type"/></label>
                    <select name="event-type" id="event-type">
                        <option value="social"><fmt:message key="create-event.form.event-type.social"/></option>
                        <option value="corporate"><fmt:message key="create-event.form.event-type.corporate"/></option>
                        <option value="religious"><fmt:message key="create-event.form.event-type.religious"/></option>
                        <option value="academic"><fmt:message key="create-event.form.event-type.academic"/></option>
                        <option value="cultural"><fmt:message key="create-event.form.event-type.cultural"/></option>
                        <option value="sports"><fmt:message key="create-event.form.event-type.sports"/></option>
                    </select>
                </div>
                <button type="submit"><fmt:message key="create-event.form.button"/></button>
            </form>
        </div>
    </main>
    <%@ include file="footer.jsp" %>
</body>
</html>