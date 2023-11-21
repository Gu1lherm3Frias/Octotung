<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <title>Octotung - Welcome!</title>
</head>
<body>
    <div class="app-container">
        <%@ include file="header.jsp" %>
        <div class="main">
            <div class="hero">
                <h1>IMAGINE UM LUGAR...</h1>
                <p>...Onde seus eventos favoritos estão tão próximos que já fazem parte de você. Um lugar onde comprar e divulgar eventos se torna fácil.</p>
                <div class="event-hero-button">
                    <a href="events">Conferir Eventos</a>
                </div>
            </div>
        </div>
        <div class="section-ticket">
            <div class="section-text-content">    
                <h2>OS MAIORES EVENTOS...</h2>
                <p>Os seus maiores sonhos sendo realizados,  conhecendo seus ídolos, ou até mesmo fazendo algo junto deles.<br>O Octotung te levará a experiências jamais imaginadas. </p>
                <div class="buy-tickets-button">
                    <a href="events">Adquira já seu ingresso</a>
                </div>
            </div>
            <img src="${pageContext.request.contextPath}/resources/public/images/tickets.svg" alt="">
        </div>
        <div class="section-search">
            <div class="section-text-content">
                <h2>Encontre os melhores eventos</h2>
                <p>Aqui é o lugar onde os melhores estão desde músicos, artistas, apresentadores, palestrantes entre outros.</p>
                <p>IMAGINA ESTAR VENDO AQUELE QUE VOCÊ MAIS ADMIRA DE PERTINHO?</p>
            </div>
            <img src="${pageContext.request.contextPath}/resources/public/images/search-in-notebook.svg" alt="">
        </div>
        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>