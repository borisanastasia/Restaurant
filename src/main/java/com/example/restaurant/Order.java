package com.example.restaurant;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data // добавляет геттеры и сеттеры
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private List<Meal> meals;
    @ManyToOne
    private Table table;
    @ManyToMany
    private List<Table> tables;
}
