package ru.itis.inf301.semestr.service;

import ru.itis.inf301.semestr.model.Cart;
import ru.itis.inf301.semestr.repository.OrderRepository;

import java.util.List;

public class OrderService {
    private final OrderRepository repository;

    public OrderService() {
        repository = new OrderRepository();
    }

    public void addOrder(List<Cart> carts, String address) {
        if (!carts.isEmpty()) repository.addOrder(carts, address);
    }
}
