package ru.itis.inf301.semestr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PizzaAndQuantity {
    Pizza pizza;
    int quantity;
}
