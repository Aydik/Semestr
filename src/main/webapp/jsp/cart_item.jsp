<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<div class="cart-item">
    <div class="item-photo">
        <img src="/static/images/products/${item.pizza.photo}.jpg" alt="">
    </div>
    <div class="item-content">
        <div class="main-info">
            <div class="name-and-price">
                <div class="name">
                    ${item.pizza.name}
                </div>
                <div class="price">
                    ${item.pizza.price * item.quantity} ₽
                </div>
            </div>
            <div class="weight">
                ${item.pizza.weight} г
            </div>
        </div>
        <div class="quantity-container">
            <button id="buttonDelete${item.pizza.id}" class="buttonDelete">
                <img src="${pageContext.request.contextPath}/static/images/vector/basket.svg"
                     alt="delete from cart">
            </button>
            <div class="correct-quantity">
                <button id="buttonMinus${item.pizza.id}" class="buttonMinus">
                    <img src="${pageContext.request.contextPath}/static/images/vector/minus.svg"
                         alt="reduce the number">
                </button>
                <div class="quantity">
                    ${item.quantity}
                </div>
                <button id="buttonPlus${item.pizza.id}" class="buttonPlus">
                    <img src="${pageContext.request.contextPath}/static/images/vector/plus.svg"
                         alt="increase the number">
                </button>
            </div>
        </div>
    </div>
</div>
<hr>