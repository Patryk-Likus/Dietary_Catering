package com.Dietary_Catering.Starter.DB;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column
    @Size(min = 2, message = "Imię musi zawierać minimum 2 znaki")
    private String name;


    @Column
    @Size(min=2, message = "Nazwisko musi zawierać minimum 2 znaki")
    private String surname;

    @Column
    @Email
    @Size(min = 1, message= "Adres email musi być wypełniony oraz zawierać znak @")
    private String email;

    @Column
    @Size(min = 9, message = "Zły numer telefonu - minimum 9 znaków")
    private String phoneNumber;

    @Column
    @Size(min = 2, message = "Podana nazwa ulicy jest zbyt krótka")
    private String streetAndNumber;

    @Column
    @Size(min = 2, message = "Miasto musi zawierać minimum 2 znaki")
    private String city;

    @Column
    @Size(min = 5, message = "Kod pocztowy musi zawierać minimum 5 znaków oraz być oddzielony znakiem '-'")
    private String postCode;

    @Column
    @Size(min = 2, message = "Login musi zawierać minimum 2 znaki")
    private String login;

    @Column
    @Size(min = 1, message = "Uzupełnij pole")
    private String password;

    @Column
    private String role = "USER";

    @Column(columnDefinition = "boolean default false")
    private boolean enabled;

    @Column
    private String confirmationToken;
}
