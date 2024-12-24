const addButtons = Array.from(document.getElementsByClassName("buttonAdd"));
const minusButtons = Array.from(document.getElementsByClassName("buttonMinus"));
const plusButtons = Array.from(document.getElementsByClassName("buttonPlus"));
const deleteButtons = Array.from(document.getElementsByClassName("buttonDelete"));
const clearCartButton = document.getElementById("clearCartButton");

for (const item of addButtons) {
    const pizza_id = item.id.slice(9);
    item.addEventListener('click', function () {
        addCart(pizza_id);
    });
}

for (const item of minusButtons) {
    const pizza_id = item.id.slice(11);
    item.addEventListener('click', function () {
        reduceQuantity(pizza_id);
    });
}

for (const item of plusButtons) {
    const pizza_id = item.id.slice(10);
    item.addEventListener('click', function () {
        addCart(pizza_id);
    });
}

for (const item of deleteButtons) {
    const pizza_id = item.id.slice(12);
    item.addEventListener('click', function () {
        deleteCart(pizza_id);
    });
}
if (clearCartButton){
    clearCartButton.addEventListener('click', function () {
        clearCart();
    });
}

function addCart(pizza_id) {
    const action = `action=${encodeURIComponent("addCart")}&pizza_id=${encodeURIComponent(pizza_id)}`;
    fetchReq(action)
}

function reduceQuantity(pizza_id) {
    const action = `action=${encodeURIComponent("reduceQuantity")}&pizza_id=${encodeURIComponent(pizza_id)}`;
    fetchReq(action)
}

function deleteCart(pizza_id) {
    const action = `action=${encodeURIComponent("deleteCart")}&pizza_id=${encodeURIComponent(pizza_id)}`;
    fetchReq(action)
}

function clearCart() {
    const action = `action=${encodeURIComponent("clearCart")}`;
    fetchReq(action)
}

function fetchReq(action) {
    fetch("/cart/service", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded", // Указываем тип передаваемых данных
        },
        body: action, // Передаем ID товара в теле запроса
    })
        .then((response) => {
            if (response.status === 401) {
                return response.json().then((data) => {
                    if (data.redirect) {
                        window.location.href = data.redirect;
                    }
                });
            }
            if (!response.ok) {
                throw new Error(`Ошибка: ${response.status}`);
            }
            if (response.status === 204) console.log("Запрос выполнен успешно");
            return response;
        }).catch((error) => {
        console.error("Ошибка запроса:", error);
    });
    location.reload()
}
