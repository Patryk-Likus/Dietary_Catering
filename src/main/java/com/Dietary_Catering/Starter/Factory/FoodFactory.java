package com.Dietary_Catering.Starter.Factory;

import com.Dietary_Catering.Starter.DB.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodFactory {

    private static List<Food> foodList = new ArrayList<Food>();

    static {
        foodList.add(new Food("standard","Strandard",30, "Tu Będzie opis wybranej diety. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque, perferendis!"));
        foodList.add(new Food("glutenfree","Bez Glutenu",30, "Tu Będzie opis wybranej diety. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque, perferendis!"));
        foodList.add(new Food("lactosefree","Bez Laktozy",30, "Tu Będzie opis wybranej diety. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque, perferendis!"));
        foodList.add(new Food("sport","Sport",30, "Tu Będzie opis wybranej diety. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque, perferendis!"));
        foodList.add(new Food("vege","Vege",30, "Tu Będzie opis wybranej diety. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque, perferendis!"));
        foodList.add(new Food("vegefish","Vege + Ryba",30, "Tu Będzie opis wybranej diety. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Doloremque, perferendis!"));



    }

    public static List<Food> getFoodList() {
        return foodList;
    }
}
