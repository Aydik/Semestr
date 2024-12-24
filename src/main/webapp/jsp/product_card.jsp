<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<div class="product-card">
    <div class="item-photo">
        <img src="/static/images/products/<%=pizza.getPhoto()%>.jpg" alt="">
    </div>
    <div class="item-header">
        <div class="title"><%=pizza.getName()%>
        </div>
        <div class="weight"><%=pizza.getWeight()%> г</div>
    </div>
    <hr>
    <div class="item-description">
        <%=pizza.getComposition()%>
    </div>
    <div class="item-price">
        <div class="price"><%=pizza.getPrice()%> ₽</div>
        <%if (session == null || !quantityMap.containsKey(pizza.getId())) {%>
        <button id="buttonAdd<%=pizza.getId()%>" class="button buttonAdd">
            <img src="${pageContext.request.contextPath}/static/images/vector/plus.svg" class="plus" alt="add to cart">
        </button>
        <%} else {%>
        <div class="correct-quantity">
            <button id="buttonDelete<%=pizza.getId()%>" class="buttonDelete">
                <img src="${pageContext.request.contextPath}/static/images/vector/basket.svg"
                     alt="delete from cart">
            </button>
            <button id="buttonMinus<%=pizza.getId()%>" class="button buttonMinus">
                <img src="${pageContext.request.contextPath}/static/images/vector/minus.svg" alt="reduce the number">
            </button>
            <div class="quantity">
                <%=quantityMap.get(pizza.getId())%>
            </div>
            <button id="buttonPlus<%=pizza.getId()%>" class="button buttonPlus">
                <img src="${pageContext.request.contextPath}/static/images/vector/plus.svg"
                     alt="increase the number">
            </button>
        </div>
        <%}%>
    </div>
</div>