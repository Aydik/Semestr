package ru.itis.inf301.semestr.service;

import ru.itis.inf301.semestr.model.Cart;
import ru.itis.inf301.semestr.repository.CartRepository;

import java.util.List;

public class CartService {

    private final CartRepository repository;

    public CartService() {
        repository = new CartRepository();
    }

    public List<Cart> findByUser(Long userId) {
        return repository.findByUser(userId);
    }

    public int getQuantity(Long userId, Long pizzaId) {
        return repository.getQuantity(userId, pizzaId);
    }

    public void addPizza(Long userId, Long pizzaId) {
        int quantity = getQuantity(userId, pizzaId);
        if (quantity == 0) {
            repository.addCart(userId, pizzaId, 1);
        } else{
            repository.updateQuantity(userId, pizzaId, quantity + 1);
        }
    }

    public void removeCartsByUser(Long userId) {
        repository.deleteByUser(userId);
    }
    public void removeCart(Long userId, Long pizzaId) {
        repository.deleteByUserAndPizza(userId, pizzaId);
    }
}