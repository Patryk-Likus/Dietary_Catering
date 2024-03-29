package com.Dietary_Catering.Starter.Services;

import com.Dietary_Catering.Starter.DB.ContactForm;
import com.Dietary_Catering.Starter.DB.Person;
import com.Dietary_Catering.Starter.DB.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createPerson(Person person){
        userRepository.createUser(person);
    }

    public List<Person> getPersons() {
        return new ArrayList<>(userRepository.getAllPersons());
    }

    public Person getPersonById(int id){
       return userRepository.getPersonById(id);
    }

    public Person getPersonByLogin(String login){
        return userRepository.getPersonByLogin(login);
    }

    public Person getPersonByToken(String token){
        return userRepository.getPersonByConfirmationToken(token);
    }

    public List<Person> getPersonByLoginList(String login){
        return userRepository.getPersonByLoginList(login);
    }

    public void updatePerson(Person person){
        userRepository.updatePerson(person);
    }

    public void deletePerson(Person person){
        userRepository.deletePerson(person);
    }



    public void createContactForm(ContactForm contactForm){
        userRepository.createForm(contactForm);
    }

    public List<ContactForm> getAllContactForms(){
       return new ArrayList<>(userRepository.getAllContactForms());
    }

    public void updateContact(ContactForm contactForm) {
        userRepository.updateContact(contactForm);
    }

    public void deleteContact(ContactForm contactForm) {
        userRepository.deleteContact(contactForm);
    }

    public ContactForm getContactById(int id) {
        return userRepository.getContactById(id);
    }



}






