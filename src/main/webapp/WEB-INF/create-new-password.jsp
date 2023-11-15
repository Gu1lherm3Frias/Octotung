<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="public/assets/images/favico.svg" type="image/svg+xml">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/create-new-pswd.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <title>Octotung - Código de confirmação</title>
</head>
<body>
    <div class="create-new-pswd-container">
        <div class="form-container">
            <div class="form-container-block">
                <a href="index">
                    <svg id="arrow-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><!--! Font Awesome Pro 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M9.4 233.4c-12.5 12.5-12.5 32.8 0 45.3l160 160c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L109.2 288 416 288c17.7 0 32-14.3 32-32s-14.3-32-32-32l-306.7 0L214.6 118.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0l-160 160z"/></svg>
                </a>
                <%@ include file="error-handlers/form-error.jsp" %>
                <h2>Ihuu, insira sua nova senha!</h2>
                <p>Ufa agora a diversão pode continuar.</p>
                <form class="create-new-pswd-form" action="createNewPassword" method="POST">
                    <label for="new-password">Nova Senha:</label>
                    <input type="password" id="new-password" name="new-password">
                    <label for="confirm-password">Confirmar Senha:</label>
                    <input type="password" id="confirm-new-password" name="confirm-new-password">
                    <p>A senha deve conter no mínimo 8 caracteres e 1 caractere especial.</p>
                    <button type="submit">Criar nova senha</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html> 