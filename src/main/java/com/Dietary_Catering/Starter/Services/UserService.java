package com.Dietary_Catering.Starter.Services;

import com.Dietary_Catering.Starter.DB.Food;
import com.Dietary_Catering.Starter.DB.OrderHistory;
import com.Dietary_Catering.Starter.DB.Person;
import com.Dietary_Catering.Starter.DB.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void createPerson(Person person){
        userRepository.createUser(person);
    }


    public List<Person> getPersons() {
        return new ArrayList<>(userRepository.getAllPersons());
    }

    public Person getPersonById(int id){
       return userRepository.getPersonById(id);
    }

    public List<Food> getFoodList() {
        return new ArrayList<>(userRepository.getAllFoods());
    }


    public Food getFoodById(int id){
        return userRepository.getFoodById(id);
    }

    public void saveOrderHistory(OrderHistory orderHistory) {
        userRepository.saveOrderHistory(orderHistory);
    }
//    public void savefood(Food food){
//        userRepository.createFood(food);
//    }


}
