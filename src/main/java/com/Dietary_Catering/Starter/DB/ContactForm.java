package com.Dietary_Catering.Starter.DB;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ContactForm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @NotNull
    @Size(min = 3, message = "Imię musi być większe niż 2 znaki")
    private String name;

    @Column
    @Size(min = 3, message = "Nazwisko musi być większe niż 2 znaki")
    private String surname;

    @Column
    @Email
    @Size(min = 5, message = "Adres email musi być wypełniony oraz zawierać znak @")
    private String email;

    @Column
    @Size(min = 1, max = 10, message = "Wiadomość musi mieć minimum 1 znak. (maks. 8000)")
    private String message;

    public ContactForm() {
    }

    public ContactForm(String name, String surname, String email, String message) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactForm{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
