package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.Food;
import com.Dietary_Catering.Starter.DB.Person;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

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
    public void createFood(Food food) {
        em.persist(food);
    }


}
