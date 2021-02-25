package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.ContactForm;
import com.Dietary_Catering.Starter.DB.OrderHistory;
import com.Dietary_Catering.Starter.DB.Person;

import java.util.Collection;
import java.util.List;

public interface UserRepository {

    void createUser(Person user);

    void createForm(ContactForm contactForm);

    Collection<Person> getAllPersons();

    Person getPersonById(int id);

    Person getPersonByConfirmationToken(String token);

    List<Person> getPersonByLoginList(String login);

    Person getPersonByLogin(String login);

    void updatePerson(Person person);

    void deletePerson(Person person);

    Collection<ContactForm> getAllContactForms();


    void updateContact(ContactForm contactForm);

    void deleteContact(ContactForm contactForm);

    ContactForm getContactById(int id);



}
