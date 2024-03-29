package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.ContactForm;
import com.Dietary_Catering.Starter.DB.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DbUserRepository implements UserRepository {

    private final EntityManager em;


    @Transactional
    public void createUser(Person person) {
        em.persist(person);
    }

    @Override
    public Collection<Person> getAllPersons() {
        return em.createQuery("from Person where role='USER'", Person.class).getResultList();
    }


    @Transactional
    public Person getPersonById(int id) {
        return em.createQuery("from Person where id=:id", Person.class).setParameter("id", id).getSingleResult();
    }

    @Transactional
    public Person getPersonByLogin(String login) {
        return em.createQuery("from Person where login=:login", Person.class).setParameter("login", login).getSingleResult();
    }

    @Transactional
    public void updatePerson(Person person) {
        em.merge(person);
    }

    @Transactional
    public void deletePerson(Person person) {
        Person searchPerson = em.find(Person.class, person.getId());
        em.remove(searchPerson);

    }

    @Transactional
    public List<Person> getPersonByLoginList(String login) {
        return em.createQuery("from Person where login=:login", Person.class).setParameter("login", login).getResultList();
    }

    @Transactional
    public void createForm(ContactForm contactForm) {
        em.persist(contactForm);
    }

    @Transactional
    public Collection<ContactForm> getAllContactForms() {
        return em.createQuery("from ContactForm", ContactForm.class).getResultList();
    }

    @Transactional
    public void updateContact(ContactForm contactForm) {
        em.merge(contactForm);
    }

    @Transactional
    public void deleteContact(ContactForm contactForm) {
        ContactForm searchContact = em.find(ContactForm.class, contactForm.getId());
        em.remove(searchContact);
    }

    @Transactional
    public ContactForm getContactById(int id) {
        return em.createQuery("from ContactForm where id=:id", ContactForm.class).setParameter("id", id).getSingleResult();
    }

    @Transactional
    public Person getPersonByConfirmationToken(String token) {
        return em.createQuery("from Person where confirmationToken=:confirmationToken", Person.class).setParameter("confirmationToken", token).getSingleResult();
    }

}
