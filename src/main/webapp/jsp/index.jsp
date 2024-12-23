<%@ page import="ru.itis.inf301.semestr.model.Pizza" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>PIZZA FAST</title>
    <link rel="stylesheet" href="../static/styles/index.css">
</head>
<body>
<%@include file="header.jsp" %>
<main class="main">
    <div class="banner">
        <img class="banner-image" src="/static/images/pictures/banner.jpg" alt="">
        <div class="marque">
            <div class="marque-content">
                <div class="collection">
                    <span>PIZZA FAST</span>
                    <img src="/static/images/vector/pizza_mini.svg" alt="">
                    <span>ЗАКАЗАТЬ ОНЛАЙН</span>
                    <img src="/static/images/vector/pizza_mini.svg" alt="">

                    <span>PIZZA FAST</span>
                    <img src="/static/images/vector/pizza_mini.svg" alt="">
                    <span>ЗАКАЗАТЬ ОНЛАЙН</span>
                    <img src="/static/images/vector/pizza_mini.svg" alt="">

                    <span>PIZZA FAST</span>
                    <img src="/static/images/vector/pizza_mini.svg" alt="">
                    <span>ЗАКАЗАТЬ ОНЛАЙН</span>
                    <img src="/static/images/vector/pizza_mini.svg" alt="">

                    <span>PIZZA FAST</span>
                    <img src="/static/images/vector/pizza_mini.svg" alt="">
                    <span>ЗАКАЗАТЬ ОНЛАЙН</span>
                    <img src="/static/images/vector/pizza_mini.svg" alt="">

                    <span>PIZZA FAST</span>
                    <img src="/static/images/vector/pizza_mini.svg" alt="">
                    <span>ЗАКАЗАТЬ ОНЛАЙН</span>
                    <img src="/static/images/vector/pizza_mini.svg" alt="">
                </div>
            </div>
        </div>
    </div>
    <div class="catalog">
        <%
            List<Pizza> products = (List<Pizza>) request.getAttribute("products");
            for (var pizza: products) {
        %>
            <%@include file="product_card.jsp"%>
        <%}%>
    </div>
</main>
<%@include file="footer.jsp" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="../static/js/add_to_cart.js"></script>
</body>
</html>