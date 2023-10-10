<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="public/assets/images/favico.svg" type="image/svg+xml">
    <link rel="stylesheet" href="styles/global.css">
    <link rel="stylesheet" href="styles/recover-code.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lalezar&family=Modak&family=Noto+Sans:wght@400;500;600;700;800&display=swap" rel="stylesheet">
    <title>Octotung - Código de confirmação</title>
</head>
<body>
    <div class="recover-code-container">
        <div class="form-container">
            <div class="form-container-block">
                <a href="index.jsp">
                    <svg id="arrow-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><!--! Font Awesome Pro 6.4.2 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M9.4 233.4c-12.5 12.5-12.5 32.8 0 45.3l160 160c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L109.2 288 416 288c17.7 0 32-14.3 32-32s-14.3-32-32-32l-306.7 0L214.6 118.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0l-160 160z"/></svg>
                </a>
                <h2>Código de confirmação?</h2>
                <p>Insira o código de 6 dígitos que enviamos no seu Email.</p>
                <form class="recover-code-form" action="" method="POST">
                    <label for="code">Código:</label>
                    <div class="code-digits">
                        <input type="tel" class="code" maxlength="1" pattern="[0-9]" name="code">
                        <input type="tel" class="code" maxlength="1" pattern="[0-9]" name="code">
                        <input type="tel" class="code" maxlength="1" pattern="[0-9]" name="code">
                        <input type="tel" class="code" maxlength="1" pattern="[0-9]" name="code">
                        <input type="tel" class="code" maxlength="1" pattern="[0-9]" name="code">
                        <input type="tel" class="code" maxlength="1" pattern="[0-9]" name="code">
                    </div>
                    <p>O código não chegou?<a class="alt-links" href="">Reenviar código</a></p>
                    <button type="submit">Confirmar código</button>
                </form>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        const form = document.querySelector("form")
        const inputs = form.querySelectorAll("input")

        const KEYBOARDS = {
            backspace: 8,
            arrowLeft: 37,
            arrowRight: 39,
        }

        function handleInput(e) {
            const input = e.target
            const nextInput = input.nextElementSibling
            if (nextInput && input.value) {
                nextInput.focus()
                if (nextInput.value)
                    nextInput.select() 
            }
        }

        function handlePaste(e) {
            e.preventDefault()
            const paste = e.clipboardData.getData("text")
            inputs.forEach((input, i) => {
                input.value = paste[i] || ""
            })
        }

        function handleBackspace(e) {
            const input = e.target
            if (input.value) {
                input.value = ""
                return
            }
            input.previousElementSibling.focus()
        }

        function handleArrowLeft(e) {
            const previousInput = e.target.previousElementSibling
            if (!previousInput) return
            previousInput.focus()
        }

        function handleArrowRight(e) {
            const nextInput = e.target.nextElementSibling
            if (!nextInput) return
            nextInput.focus()
        }

        form.addEventListener('input', handleInput)
        inputs[0].addEventListener('paste', handlePaste)

        inputs.forEach(input => {
            input.addEventListener('focus', e => {
                setTimeout(() => {
                    e.target.select()
                }, 0)
            })

            input.addEventListener('keydown', e => {
                switch(e.key) {
                    case KEYBOARDS.backspace:
                        handleBackspace(e)
                        break
                    case KEYBOARDS.arrowLeft:
                        handleArrowLeft(e)
                        break
                    case KEYBOARDS.arrowRight:
                        handleArrowRight(e)
                        break
                    default:
                }
            })
        })
    </script>
</body>
</html> 