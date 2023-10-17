<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="public/assets/images/favico.svg" type="image/svg+xml">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/signup.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <title>Octotung - Cadastrar-se</title>
</head>
<body>
    <div class="signup-container">
        <div class="form-container">
            <div class="form-container-block">
                <a href="index.jsp">
                    <svg id="arrow-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><!--! Font Awesome Pro 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M9.4 233.4c-12.5 12.5-12.5 32.8 0 45.3l160 160c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L109.2 288 416 288c17.7 0 32-14.3 32-32s-14.3-32-32-32l-306.7 0L214.6 118.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0l-160 160z"/></svg>
                </a>
                <%@ include file="error-handlers/form-error.jsp" %>
                <h2>Crie a sua conta!</h2>
                <p>É uma honra inenarrável te conhecer.</p>
                <form class="signup-form" action="signUpServlet" method="POST">
                    <label for="username">Nome:</label>
                    <input type="text" id="username" name="username" value="${username}">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" value="${email}">
                    <label for="password">Senha:</label>
                    <input type="password" id="password" name="password">
                    <label for="confirm-password">Confirme sua Senha:</label>
                    <input type="password" id="confirm-password" name="confirm-password">
                    <button type="submit">Criar conta</button>
                </form>
                <p>Já possui uma conta?<a class="alt-links" href="login.jsp">Log In</a></p>
            </div>
        </div>
    </div>
</body>
</html>