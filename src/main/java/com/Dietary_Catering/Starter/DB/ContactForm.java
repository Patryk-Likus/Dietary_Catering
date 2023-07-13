package com.Dietary_Catering.Starter.DB;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@ToString
@Accessors(chain = true)
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
}
