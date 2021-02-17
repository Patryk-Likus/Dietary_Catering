package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.Person;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void createUser(Person user);

   Collection<Person> getAllPersons();



}
