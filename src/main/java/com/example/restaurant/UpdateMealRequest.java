package com.example.restaurant;

import lombok.Data;

@Data
public class UpdateMealRequest {
    private Long updateMealId;
    private String name;
    private String compound;
    private double price;

    public String getName() {
        return name;
    }
    public String getCompound() {
        return compound;
    }
    public double getPrice() {
        return price;
    }
    public Long getUpdateMealId() {
        return updateMealId;
    }

    public void setUpdateMealId(Long updateMealId) {
        this.updateMealId = updateMealId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompound(String compound) {
        this.compound = compound;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
