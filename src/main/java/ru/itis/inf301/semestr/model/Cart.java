package ru.itis.inf301.semestr.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
    private Long id;
    private Long user_id;
    private Pizza pizza;
    private int quantity;

    public Cart() {
    }

    public Cart(Long id, Long user_id, Pizza pizza, int quantity) {
        this.id = id;
        this.user_id = user_id;
        this.pizza = pizza;
        this.quantity = quantity;
    }
}
