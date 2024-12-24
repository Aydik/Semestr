package ru.itis.inf301.semestr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pizza {
    private Long id;
    private String name;
    private String composition;
    private int weight;
    private int price;
    private String photo;
}
