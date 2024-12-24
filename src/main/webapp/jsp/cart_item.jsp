<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<div class="cart-item">
    <div class="item-photo">
        <img src="/static/images/products/<%=cart_item.getPizza().getPhoto()%>.jpg" alt="">
    </div>
    <div class="item-content">
        <div class="main-info">
            <div class="name-and-price">
                <div class="name">
                    <%=cart_item.getPizza().getName()%>
                </div>
                <div class="price">
                    <%=cart_item.getPizza().getPrice() * cart_item.getQuantity()%> ₽
                </div>
            </div>
            <div class="weight">
                <%=cart_item.getPizza().getWeight()%> г
            </div>
        </div>
        <div class="quantity-container">
            <button id="buttonDelete<%=cart_item.getPizza().getId()%>" class="buttonDelete">
                <img src="${pageContext.request.contextPath}/static/images/vector/basket.svg"
                     alt="delete from cart">
            </button>
            <div class="correct-quantity">
                <button id="buttonMinus<%=cart_item.getPizza().getId()%>" class="buttonMinus">
                    <img src="${pageContext.request.contextPath}/static/images/vector/minus.svg"
                         alt="reduce the number">
                </button>
                <div class="quantity">
                    <%=cart_item.getQuantity()%>
                </div>
                <button id="buttonPlus<%=cart_item.getPizza().getId()%>" class="buttonPlus">
                    <img src="${pageContext.request.contextPath}/static/images/vector/plus.svg"
                         alt="increase the number">
                </button>
            </div>
        </div>
    </div>
</div>
<hr>