package ru.itis.inf301.semestr.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String phone;
    private String username;
    private String password;

    public User() {
    }

    public User(Long id, String phone, String username, String password) {
        this.id = id;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }
}
