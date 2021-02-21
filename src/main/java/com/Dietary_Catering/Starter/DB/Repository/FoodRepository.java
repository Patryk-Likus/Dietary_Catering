package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.ContactForm;
import com.Dietary_Catering.Starter.DB.Food;

import java.util.Collection;

public interface FoodRepository {

    Collection<Food> getAllFoods();

    void createFood(Food food);

    void updateFood(Food food);

    void deleteFood(Food food);

    Food getFoodById(int id);


}
