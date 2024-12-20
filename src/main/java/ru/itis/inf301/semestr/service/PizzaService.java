package ru.itis.inf301.semestr.service;

import ru.itis.inf301.semestr.model.Pizza;
import ru.itis.inf301.semestr.repository.PizzaRepository;

import java.util.List;

public class PizzaService {

    private final PizzaRepository repository;

    public PizzaService() {
        repository = new PizzaRepository();
    }

    public List<Pizza> findAll() {
        return repository.findAll();
    }

    public Pizza findById(Long id) {
        return repository.findById(id);
    }
    public void addUser(Pizza pizza) {repository.addPizza(pizza);}
}