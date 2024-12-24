<%@ page import="ru.itis.inf301.semestr.model.Pizza" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="ru.itis.inf301.semestr.controller.IndexPageServlet" %>
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
        <img class="banner-image" src="${pageContext.request.contextPath}/static/images/pictures/banner.jpg" alt="">
        <div class="marque">
            <div class="marque-content">
                <div class="collection">
                    <span>PIZZA FAST</span>
                    <img src="${pageContext.request.contextPath}/static/images/vector/pizza_mini.svg" alt="">
                    <span>ЗАКАЗАТЬ ОНЛАЙН</span>
                    <img src="${pageContext.request.contextPath}/static/images/vector/pizza_mini.svg" alt="">

                    <span>PIZZA FAST</span>
                    <img src="${pageContext.request.contextPath}/static/images/vector/pizza_mini.svg" alt="">
                    <span>ЗАКАЗАТЬ ОНЛАЙН</span>
                    <img src="${pageContext.request.contextPath}/static/images/vector/pizza_mini.svg" alt="">

                    <span>PIZZA FAST</span>
                    <img src="${pageContext.request.contextPath}/static/images/vector/pizza_mini.svg" alt="">
                    <span>ЗАКАЗАТЬ ОНЛАЙН</span>
                    <img src="${pageContext.request.contextPath}/static/images/vector/pizza_mini.svg" alt="">

                    <span>PIZZA FAST</span>
                    <img src="${pageContext.request.contextPath}/static/images/vector/pizza_mini.svg" alt="">
                    <span>ЗАКАЗАТЬ ОНЛАЙН</span>
                    <img src="${pageContext.request.contextPath}/static/images/vector/pizza_mini.svg" alt="">

                    <span>PIZZA FAST</span>
                    <img src="${pageContext.request.contextPath}/static/images/vector/pizza_mini.svg" alt="">
                    <span>ЗАКАЗАТЬ ОНЛАЙН</span>
                    <img src="${pageContext.request.contextPath}/static/images/vector/pizza_mini.svg" alt="">
                </div>
            </div>
        </div>
    </div>
    <div class="catalog">
        <%
            List<Pizza> products = (List<Pizza>) request.getAttribute("products");
            HashMap<Long, Integer> quantityMap = (HashMap<Long, Integer>) request.getAttribute("quantityMap");
            for (var pizza : products) {
        %>
        <%@include file="product_card.jsp" %>
        <%}%>
    </div>
</main>
<%@include file="footer.jsp" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="../static/js/cart.js"></script>
</body>
</html>