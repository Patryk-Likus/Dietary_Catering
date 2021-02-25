package com.Dietary_Catering.Starter.DB;

import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Set;


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
    private String role = "ADMIN";

    @Column(columnDefinition = "boolean default false")
    private boolean enabled;

    @Column
    private String confirmationToken;

    @OneToMany(mappedBy="person")
    Set<OrderHistory> orderHistory;

    public Person() {
    }

    public Person(String name, String surname, String email, String phoneNumber, String streetAndNumber, String city, String postCode, String login , String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.streetAndNumber = streetAndNumber;
        this.city = city;
        this.postCode = postCode;
        this.login = login;
        this.password = password;
        this.enabled = false;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' + ", streetAndNumber='" + streetAndNumber + '\'' + ", city='" + city + '\'' + ", " +
                "postCode='" + postCode + '\'' + ", login='" + login + '\''  + ", password='" + password + '\'' + '}';
    }
}
