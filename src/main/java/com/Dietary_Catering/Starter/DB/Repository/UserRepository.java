package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.ContactForm;
import com.Dietary_Catering.Starter.DB.Food;
import com.Dietary_Catering.Starter.DB.OrderHistory;
import com.Dietary_Catering.Starter.DB.Person;
import java.util.Collection;


public interface UserRepository {

    void createUser(Person user);

    void createForm(ContactForm contactForm);

   Collection<Person> getAllPersons();


   Collection<Food> getAllFoods();

//   void createFood(Food food);

    
    Person getPersonById(int id);
    
    Food getFoodById(int id);

    Collection<ContactForm> getAllContactForms();




    void saveOrderHistory(OrderHistory orderHistory);

    Collection<OrderHistory> getAllOrderHistory();
}
