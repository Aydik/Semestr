<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>PIZZA FAST</title>
    <link rel="stylesheet" href="../static/styles/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
</head>
<body>
<%@include file="header.jsp" %>
<main class="main">
    <div class="main_div">
        <div class="title">Регистрация</div>
        <% String error = (String) request.getAttribute("error");
            if (request.getAttribute("error") != null) {%>
        <div class="error">
            <div class="error-background"></div>
            <p class="error-text">
                <%=error%>
            </p>
        </div>
        <%}%>
        <form method="post">
            <div class="input_box">
                <input type="text"
                       placeholder="Логин"
                       required name="username"
                       maxlength="50">
                <div class="icon"><i class="fas fa-user"></i></div>
            </div>
            <div class="input_box">
                <input id="phone" type="tel"
                       placeholder="+7 (___) ___-__-__"
                       maxlength="18"
                       required
                       name="phone">
                <div class="icon"><i class="fas fa-phone"></i></div>
            </div>
            <div class="input_box">
                <input type="password"
                       placeholder="Пароль"
                       required name="password"
                       maxlength="100">
                <div class="icon"><i class="fas fa-lock"></i></div>
            </div>
            <div class="input_box">
                <input type="password"
                       placeholder="Повторите пароль"
                       required name="password_copy"
                       maxlength="100">
                <div class="icon"><i class="fas fa-lock"></i></div>
            </div>
            <div class="input_box button">
                <input type="submit" value="Зарегистрироваться">
            </div>
            <div class="sign_up">
                <a class="link" href="${pageContext.request.contextPath}/login">Уже есть аккаунт? <span class="red">Войти</span></a>
            </div>
        </form>
    </div>
    <script src="../static/js/phone_input.js"></script>
</main>
</body>
</html>