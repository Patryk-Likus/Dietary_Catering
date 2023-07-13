package com.Dietary_Catering.Starter.DB.Repository;

import com.Dietary_Catering.Starter.DB.Person;
import com.Dietary_Catering.Starter.Services.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
class DbUserRepositoryTest {

    int id = 87;

    @Mock
    EntityManager em;

    private MockMvc mock;


    @Test
    void createUser() {
       int a = 2;
       int b = 2;
       assertTrue(a + b == 4);
    }

    @Test
    void getAllPersons() {
    }

    @Test
    @Transactional
    void getPersonById() {
        Person person = new Person();
        person = em.createQuery("from Person where id=:id", Person.class).setParameter("id", id).getSingleResult();
        assertTrue(person.getId() == 87);
        //assertThat(person).isNotNull();
    }

    @Test
    void getPersonByLogin() {
    }

    @Test
    void updatePerson() {
    }

    @Test
    void deletePerson() {
    }

    @Test
    void getPersonByLoginList() {
    }

    @Test
    void createForm() {
    }

    @Test
    void getAllContactForms() {
    }

    @Test
    void updateContact() {
    }

    @Test
    void deleteContact() {
    }

    @Test
    void getContactById() {
    }

    @Test
    void getPersonByConfirmationToken() {
    }
}