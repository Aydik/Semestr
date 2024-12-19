<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<header class="header">
    <nav class="nav">
        <a class="home" href="/">PIZZA FAST</a>
        <% HttpSession session = request.getSession(false);
            if (session != null) {
                String user = (String) session.getAttribute("user");%>
                <div class="authorized">
                    <a class="profile" href="/"><%= user %></a>
                </div>
        <% } else { %>
            <div class="unauthorized">
                <a class="login" href="/login">Войти</a>
            </div>
        <% } %>
    </nav>
</header>
