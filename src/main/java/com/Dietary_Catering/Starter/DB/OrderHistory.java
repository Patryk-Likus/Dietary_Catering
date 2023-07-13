package com.Dietary_Catering.Starter.DB;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@Accessors(chain = true)
@Entity
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne()
    @JoinColumn(name  = "food_id")
    Food food;

    @Column()
    String localDateTime;


    public OrderHistory(Person person, Food food) {
        this.person = person;
        this.food = food;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        this.localDateTime = dateTime.format(formatter);
    }

    public OrderHistory() {

    }
}
