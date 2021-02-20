package com.Dietary_Catering.Starter.Services;

import com.Dietary_Catering.Starter.DB.ContactForm;
import com.Dietary_Catering.Starter.DB.Food;
import com.Dietary_Catering.Starter.DB.OrderHistory;
import com.Dietary_Catering.Starter.DB.Person;
import com.Dietary_Catering.Starter.DB.Repository.FoodRepository;
import com.Dietary_Catering.Starter.DB.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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


    public void saveOrderHistory(OrderHistory orderHistory) {
        userRepository.saveOrderHistory(orderHistory);
    }


   public List<OrderHistory> getAllOrderHistory() {
        return new ArrayList<>(userRepository.getAllOrderHistory());
    }


    public void createContactForm(ContactForm contactForm){
        userRepository.createForm(contactForm);
    }

    public List<ContactForm> getAllContactForms(){
       return new ArrayList<>(userRepository.getAllContactForms());
    }

    public Person getPersonByLogin(String login){
        return userRepository.getPersonByLogin(login);
    }
}






