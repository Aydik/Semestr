<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<div class="product-card">
    <div class="item-photo">
        <img src="/static/images/products/<%=pizza.getPhoto()%>.jpg" alt="">
    </div>
    <div class="item-header">
        <div class="title"><%=pizza.getName()%></div>
        <div class="weight"><%=pizza.getWeight()%> гр</div>
    </div>
    <hr>
    <div class="item-description">
        <%=pizza.getComposition()%>
    </div>
    <div class="item-price">
        <div class="price"><%=pizza.getPrice()%></div>
        <button id="buttonAdd<%=pizza.getId()%>" class="add-to-cart">
            <img src="/static/images/vector/plus.svg" class="plus" alt="add to cart">
        </button>
    </div>
</div>