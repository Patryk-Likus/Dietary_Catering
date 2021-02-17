package com.Dietary_Catering.Starter.DB.Repository;

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
        return em.createQuery("from Person", Person.class).getResultList();
    }

    @Override
    public boolean findAccount(String email, String password) {
       Person isAccount = em.createQuery("from Person p where p.email=:email AND p.password=:password", Person.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
        if(isAccount.equals("null"))
            return false;
        else
            return true;
    }

}
