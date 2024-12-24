<%@ page import="ru.itis.inf301.semestr.model.Cart" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>PIZZA FAST</title>
    <link rel="stylesheet" href="../static/styles/cart.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
</head>
<body>
<%@include file="header.jsp" %>
<main class="main">
    <div class="main-div">
        <% List<Cart> cart = (List<Cart>) request.getAttribute("cart");%>
        <div class="title">
            Корзина
            <%if (!cart.isEmpty()) {%>
            <button id="clearCartButton">
                <span>Очистить корзину</span>
                <img src="${pageContext.request.contextPath}/static/images/vector/basket.svg"
                     alt="delete from cart">
            </button>
            <%}%>
        </div>
        <hr>
        <%if (!cart.isEmpty()) {%>
        <div class="not-empty-cart">
            <div class="products">
                <%
                    for (var cart_item : cart) {
                %>
                <%@include file="cart_item.jsp" %>
                <%}%>
            </div>
            <%int totalPrice = (int) request.getAttribute("totalPrice");%>
            <div class="totalPrice"><%=totalPrice%> ₽</div>
            <div class="title">Детали доставки</div>
            <form method="post">
                <div class="input_box">
                    <input type="text" placeholder="Адрес доставки" required name="address">
                    <div class="icon"><i class="fas fa-map-pin"></i></div>
                </div>
                <div class="input_box button">
                    <input type="submit" value="Создать заказ">
                </div>
            </form>
        </div>
        <%} else {%>
        <div class="empty-cart">
            <div class="empty-cart-title">Корзина пуста</div>
            <a href="${pageContext.request.contextPath}/">Добавим пиццу</a>
        </div>
        <%}%>
    </div>
</main>
<%@include file="footer.jsp" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="../static/js/cart.js"></script>
</body>
</html>