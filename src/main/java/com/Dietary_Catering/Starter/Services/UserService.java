package com.Dietary_Catering.Starter.Services;

import com.Dietary_Catering.Starter.DB.Food;
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

    public void savefood(Food food){
        userRepository.createFood(food);
    }


}
