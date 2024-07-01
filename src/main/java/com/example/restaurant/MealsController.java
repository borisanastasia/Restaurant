package com.example.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MealsController {
    private final MealService mealService;

    @GetMapping("/menu")
    public String showMenu(Model model) {
        var meals = mealService.findAll();
        model.addAttribute("meals", meals);
        model.addAttribute("orderRequest", new OrderRequest());
        return "menu";
    }

    @GetMapping("/showMealById")
    public String showById(@RequestParam("id") Long id, Model model) {
        var meal = mealService.findById(id).get();
        model.addAttribute("meal", meal);//используется внутри html
        return "meal"; //название html
    }

    @PostMapping("/create-meal")
    public String createMeal(AddMealRequest addMealRequest) {
        var meal = new Meal();
        meal.setCompound(addMealRequest.getCompound());
        meal.setName(addMealRequest.getName());
        meal.setPrice(addMealRequest.getPrice());

        mealService.save(meal);
        return "redirect:menu";
    }

    @PostMapping("/update-meal")
    public String updateMeal(UpdateMealRequest updateMealRequest) {
        var meal = new Meal();
        meal.setId(updateMealRequest.getUpdateMealId());
        meal.setName(updateMealRequest.getName());
        meal.setCompound(updateMealRequest.getCompound());
        meal.setPrice(updateMealRequest.getPrice());

        mealService.save(meal);
        return "redirect:menu";
    }

}
