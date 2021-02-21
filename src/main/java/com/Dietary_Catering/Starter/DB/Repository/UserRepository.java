package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.ContactForm;
import com.Dietary_Catering.Starter.DB.OrderHistory;
import com.Dietary_Catering.Starter.DB.Person;

import java.util.Collection;

public interface UserRepository {

    void createUser(Person user);

    void createForm(ContactForm contactForm);

    Collection<Person> getAllPersons();

    Person getPersonById(int id);

    Collection<ContactForm> getAllContactForms();

    Person getPersonByLogin(String login);

    void updateContact(ContactForm contactForm);

    void deleteContact(ContactForm contactForm);

    ContactForm getContactById(int id);

    Person getPersonByConfirmationToken(String token);

}
