<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<link rel="stylesheet" href="../static/styles/header.css">
<header class="header">
    <nav class="nav">
        <a class="home" href="${pageContext.request.contextPath}/">PIZZA FAST</a>
        <c:choose>
            <c:when test="${authenticated}">
                <div class="header-right">
                    <a class="cart" href="${pageContext.request.contextPath}/cart">
                        <span>Корзина</span>
                        <img src="${pageContext.request.contextPath}/static/images/vector/cart.svg" alt="">
                        <c:if test="${quantity != 0}">
                            <div class="quantity">
                                    ${quantity}
                            </div>
                        </c:if>
                    </a>
                    <a class="logout" href="${pageContext.request.contextPath}/logout">
                        <span>Выйти</span>
                        <img src="${pageContext.request.contextPath}/static/images/vector/logout.svg" alt="">
                    </a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="header-right">
                    <a class="login" href="${pageContext.request.contextPath}/login">
                        <span>Войти</span>
                        <img src="${pageContext.request.contextPath}/static/images/vector/login.svg" alt="">
                    </a>
                </div>
            </c:otherwise>
        </c:choose>
    </nav>
</header>
