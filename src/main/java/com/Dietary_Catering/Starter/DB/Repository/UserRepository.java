package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.Food;
import com.Dietary_Catering.Starter.DB.OrderHistory;
import com.Dietary_Catering.Starter.DB.Person;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void createUser(Person user);

   Collection<Person> getAllPersons();

//   void createFood(Food food);
    
    Person getPersonById(int id);
    
    Food getFoodById(int id);


    void saveOrderHistory(OrderHistory orderHistory);
}
