package com.example.restaurant;

import lombok.Data;

import java.util.List;

@Data
public class AddMealRequest {
    private String name;
    private String compound;
    private double price;
}
