package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.ContactForm;
import com.Dietary_Catering.Starter.DB.Food;
import com.Dietary_Catering.Starter.DB.OrderHistory;
import com.Dietary_Catering.Starter.DB.Person;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class DbUserRepository implements UserRepository {

    @PersistenceContext
    EntityManager em;


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
    public void saveOrderHistory(OrderHistory orderHistory) {
        em.persist(orderHistory);
    }


    @Override
    public Collection<OrderHistory> getAllOrderHistory() {
        return em.createQuery("from OrderHistory", OrderHistory.class).getResultList();
    }

    //do Formularza
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

}
