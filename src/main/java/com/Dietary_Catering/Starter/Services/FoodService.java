package com.Dietary_Catering.Starter.Services;

import com.Dietary_Catering.Starter.DB.Food;
import com.Dietary_Catering.Starter.DB.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodService {

    @Autowired
    FoodRepository foodRepository;


    public List<Food> getFoodList() {
        return new ArrayList<>(foodRepository.getAllFoods());
    }

    public Food getFoodById(int id) {
        return foodRepository.getFoodById(id);
    }

    public void savefood(Food food) {
        foodRepository.createFood(food);
    }

    public void updateFood(Food food) {
        foodRepository.updateFood(food);
    }

    public void deleteFood(Food food) {
        foodRepository.deleteFood(food);
    }

}
