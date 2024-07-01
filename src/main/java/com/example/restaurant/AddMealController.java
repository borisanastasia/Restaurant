package com.example.restaurant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddMealController {
    @GetMapping("/add-meal")
    public String showAddMealPage() {
        return "add-meal";
    }


}
