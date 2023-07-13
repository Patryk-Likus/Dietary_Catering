package com.Dietary_Catering.Starter.Factory;

import com.Dietary_Catering.Starter.DB.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodFactory {
    private static List<Food> foodList = new ArrayList<Food>();

    public static List<Food> createFoods() {
        if (foodList.isEmpty()) {
            foodList.add(new Food("standard", "Strandard", 30, "Dieta Standard składa się z 5 posiłków. Każde danie powstaje we współpracy z naszymi dietetykami, więc możesz być pewie"));
            foodList.add(new Food("glutenfree", "Bez Glutenu", 30, "Tu Będzie opis wybranej diety. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque, perferendis!"));
            foodList.add(new Food("lactosefree", "Bez Laktozy", 30, "Tu Będzie opis wybranej diety. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque, perferendis!"));
            foodList.add(new Food("sport", "Sport", 30, "Tu Będzie opis wybranej diety. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque, perferendis!"));
            foodList.add(new Food("vege", "Vege", 30, "Tu Będzie opis wybranej diety. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque, perferendis!"));
            foodList.add(new Food("vegefish", "Vege + Ryba", 30, "Tu Będzie opis wybranej diety. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque, perferendis!"));
            foodList.add(new Food("glutenlactosefree", "Bez Glutenu i Laktozy", 40, "lorem4"));
            foodList.add(new Food("lowIG", "LOW IG", 40, "lorem4"));
            foodList.add(new Food("junior", "Dla Najmłodszych", 40, "lorem4"));
            foodList.add(new Food("soft", "Soft", 40, "lorem4"));
            foodList.add(new Food("lesscarb", "Less Carb", 40, "Tu Będzie opis wybranej diety. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque, perferendis!"));
        }
        return foodList;
    }
}
