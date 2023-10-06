<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="public/assets/images/favico.svg" type="image/svg+xml">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/home.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <!-- <script src="https://cdn.tailwindcss.com"></script> -->
    <title>Octotung - Welcome!</title>
</head>
<body>
    <div class="app-container">
        <div class="header">
            <header class="header-nav">
                <a href="#">
                    <img src="public/assets/images/logo.svg" alt="logo">
                </a>
                <nav class="nav-links">
                    <a href="events.jsp">Eventos</a>
                    <a href="make-event.jsp">Criar Evento</a>
                    <a href="about-us.jsp">Sobre nós</a>
                </nav>
                <div class="login-button">
                    <a href="login.jsp">Login</a>
                </div>
            </header>
        </div>
        <div class="main">
            <div class="hero">
                <h1>IMAGINE UM LUGAR...</h1>
                <p>...Onde seus eventos favoritos estão tão próximos que já fazem parte de você. Um lugar onde comprar e divulgar eventos se torna fácil.</p>
                <div class="event-hero-button">
                    <a href="event.jsp">Conferir Eventos</a>
                </div>
            </div>
        </div>
        <div class="section-ticket">
            <div class="section-text-content">    
                <h2>OS MAIORES EVENTOS...</h2>
                <p>Os seus maiores sonhos sendo realizados,  conhecendo seus ídolos, ou até mesmo fazendo algo junto deles.<br>O Octotung te levará a experiências jamais imaginadas. </p>
                <div class="buy-tickets-button">
                    <a href="event.jsp">Adquira já seu ingresso</a>
                </div>
            </div>
            <img src="public/assets/images/tickets.svg" alt="">
        </div>
        <div class="section-search">
            <h2>Encontre os melhores eventos</h2>
            <p>Aqui é o lugar onde os melhores estão desde músicos, artistas, apresentadores, palestrantes entre outros.</p>
            <p>IMAGINA ESTAR VENDO AQUELE QUE VOCÊ MAIS ADMIRA DE PERTINHO?</p>
            <img src="public/assets/images/search-in-notebook.svg" alt="">
        </div>
        <div class="footer">
            <div class="support-social-media-content">
                <div class="social-media">
                    <p>Nossas redes sociais:</p>
                    <nav>
                        <a href="">
                            <img src="public/assets/images/github-icon.svg" alt="">
                        </a>
                        <a href="">
                            <img src="public/assets/images/discord-icon.svg" alt="">
                        </a>
                        <a href="">
                            <img src="public/assets/images/twitter-icon.svg" alt="">
                        </a>
                        <a href="">
                            <img src="public/assets/images/instagram-icon.svg" alt="">
                        </a>
                    </nav>
                </div>
                <div class="support-content">
                    <p>Suporte e contato</p>
                    <a href=""><p>support.octo@octoorg.com</p></a>
                </div>
            </div>
            <div class="sub-footer">
                <a href="#">
                    <img src="public/assets/images/logo.svg" alt="logo">
                </a>
                <div class="signup-button">
                    <a href="signup.jsp">Sign Up</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>