package com.Dietary_Catering.Starter.DB;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne
    @JoinColumn(name  = "food_id")
    Food food;

    @Column()
    String localDateTime;



    public OrderHistory() {
    }

    public OrderHistory(Person person, Food food) {
        this.person = person;
        this.food = food;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.now();
        this.localDateTime = dateTime.format(formatter);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "id=" + id +
                ", person=" + person +
                ", food=" + food +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
