package ru.itis.inf301.semestr.service;

import ru.itis.inf301.semestr.model.User;
import ru.itis.inf301.semestr.repository.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository repository;

    public UserService() {
        repository = new UserRepository();
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByName(String name) {
        return repository.findByName(name);
    }
    public void addUser(User user) {repository.addUser(user);}
}