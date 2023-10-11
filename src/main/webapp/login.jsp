<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="public/assets/images/favico.svg" type="image/svg+xml">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/signin.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <title>Octotung - Login</title>
</head>
<body>
    <div class="login-container">
        <div class="form-container">
            <div class="form-container-block">
                <a href="index.jsp">
                    <svg id="arrow-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><!--! Font Awesome Pro 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M9.4 233.4c-12.5 12.5-12.5 32.8 0 45.3l160 160c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L109.2 288 416 288c17.7 0 32-14.3 32-32s-14.3-32-32-32l-306.7 0L214.6 118.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0l-160 160z"/></svg>
                </a>
                <p>${error}</p>
                <h2>Bem-vindo!</h2>
                <p>É bom te ver novamente por aqui.</p>
                <form class="login-form" action="loginServlet" method="POST">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email">
                    <label for="password">Senha:</label>
                    <input type="password" id="password" name="password">
                    <p>Esqueceu sua senha?<a class="alt-links" href="recover-password.jsp">Crie uma nova</a></p>
                    <button type="submit">Log In</button>
                </form>
                <p>Não possui uma conta?<a class="alt-links" href="signup.jsp">Cadastre-se</a></p>
            </div>
            <div class="img-container-block">
                <img src="public/assets/images/octopus.svg" alt="">
            </div>
        </div>
    </div>
</body>
</html>