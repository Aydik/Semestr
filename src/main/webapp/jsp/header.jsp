<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<link rel="stylesheet" href="../static/styles/header.css">
<header class="header">
    <nav class="nav">
        <a class="home" href="/">PIZZA FAST</a>
        <% HttpSession session = request.getSession(false);
            if (session != null) {
                String user = (String) session.getAttribute("user");%>
        <div class="header-right">
            <a class="cart" href="/cart">
                <span>Корзина</span>
                <img src="/static/images/vector/cart.svg">
            </a>
            <a class="logout" href="/logout">
                <span><%=user%>, Выйти</span>
                <img src="/static/images/vector/logout.svg">
            </a>
        </div>
        <% } else { %>
        <div class="header-right">
            <a class="login" href="/login">
                <span>Войти</span>
                <img src="/static/images/vector/login.svg">
            </a>
        </div>
        <% } %>
    </nav>
</header>
