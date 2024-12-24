package ru.itis.inf301.semestr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Long id;
    private Long user_id;
    private Pizza pizza;
    private int quantity;
}
