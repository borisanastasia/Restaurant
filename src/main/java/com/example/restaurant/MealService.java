package com.example.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;
    public Iterable<Meal> findAll() {
        return mealRepository.findAll();
    }
    public Optional<Meal> findById(Long id) {
        return mealRepository.findById(id);
    }
    public List<Meal> findAllByIds(List<Long> ids) {
        return (List<Meal>) mealRepository.findAllById(ids);
    }
    public void save(Meal meal) {
        mealRepository.save(meal);
    }
    public void updateMealById(Long updateMealId){
        mealRepository.deleteById(updateMealId);
    }

    public void deleteMealById(Long mealDeleteId){
        mealRepository.deleteById(mealDeleteId);
    }
}
