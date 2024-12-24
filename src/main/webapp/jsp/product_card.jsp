<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<div class="product-card">
    <div class="item-photo">
        <img src="/static/images/products/${item.pizza.photo}.jpg" alt="">
    </div>
    <div class="item-header">
        <div class="title">${item.pizza.name}
        </div>
        <div class="weight">${item.pizza.weight} г</div>
    </div>
    <hr>
    <div class="item-description">
        ${item.pizza.composition}
    </div>
    <div class="item-price">
        <div class="price">${item.pizza.price} ₽</div>
        <c:choose>
            <c:when test="${item.quantity == 0}">
                <button id="buttonAdd${item.pizza.id}" class="button buttonAdd">
                    <img src="${pageContext.request.contextPath}/static/images/vector/plus.svg" class="plus" alt="add to cart">
                </button>
            </c:when>
            <c:otherwise>
                <div class="correct-quantity">
                    <button id="buttonDelete${item.pizza.id}" class="buttonDelete">
                        <img src="${pageContext.request.contextPath}/static/images/vector/basket.svg"
                             alt="delete from cart">
                    </button>
                    <button id="buttonMinus${item.pizza.id}" class="button buttonMinus">
                        <img src="${pageContext.request.contextPath}/static/images/vector/minus.svg" alt="reduce the number">
                    </button>
                    <div class="quantity">
                            ${item.quantity}
                    </div>
                    <button id="buttonPlus${item.pizza.id}" class="button buttonPlus">
                        <img src="${pageContext.request.contextPath}/static/images/vector/plus.svg"
                             alt="increase the number">
                    </button>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>