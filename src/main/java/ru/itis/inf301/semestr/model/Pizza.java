package ru.itis.inf301.semestr.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pizza {
    private Long id;
    private String name;
    private String composition;
    private int weight;
    private int price;
    private String photo;

    public Pizza() {
    }

    public Pizza(Long id, String name, String composition, int weight, int price, String photo) {
        this.id = id;
        this.name = name;
        this.composition = composition;
        this.weight = weight;
        this.price = price;
        this.photo = photo;
    }
}
