const addButtons = Array.from(document.getElementsByClassName("add-to-cart"))


function addToCart(pizza_id) {
    fetch("/cart", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded", // Указываем тип передаваемых данных
        },
        body: `action=${encodeURIComponent("addToCart")}&pizza_id=${encodeURIComponent(pizza_id)}`, // Передаем ID товара в теле запроса
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
            if(response.status === 204) console.log("Запрос выполнен успешно");
            return response;
        }).catch((error) => {
            console.error("Ошибка запроса:", error);
        });
}


for (const item of addButtons) {
    const pizza_id = item.id.slice(9);
    item.addEventListener('click', function () {
        addToCart(pizza_id)
    })
}

