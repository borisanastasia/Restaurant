package com.example.restaurant;


import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private List<Long> mealIds;

}
