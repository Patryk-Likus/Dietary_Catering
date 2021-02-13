package com.Dietary_Catering.Starter.DB;

import javax.persistence.*;


@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;


    @Column
    private String surname;

    @Column
    private String email;


    @Column
    private String phoneNumber;

    @Column
    private String streetAndNumber;

    @Column
    private String city;

    @Column
    private String postCode;

    @Column
    private String login;

    @Column
    private String password;


    public Person() {
    }

    public Person(String name, String surname, String email, String phoneNumber, String streetAndNumber, String city, String postCode,String login ,String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.streetAndNumber = streetAndNumber;
        this.city = city;
        this.postCode = postCode;
        this.login = login;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' + ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' + ", streetAndNumber='" + streetAndNumber + '\'' + ", city='" + city + '\'' + ", " +
                "postCode='" + postCode + '\'' + ", login='" + login + '\''  + ", password='" + password + '\'' + '}';
    }
}
