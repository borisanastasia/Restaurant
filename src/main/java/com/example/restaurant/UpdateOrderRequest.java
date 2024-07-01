package com.example.restaurant;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class UpdateOrderRequest {
    private Long updateOrderId;
    private Long tableId;
}
