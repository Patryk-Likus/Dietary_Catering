package com.Dietary_Catering.Starter.DB;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    LocalDateTime localDateTime;

    public OrderHistory() {
    }

    public OrderHistory(Person person, Food food) {
        this.person = person;
        this.food = food;
        this.localDateTime = localDateTime.now();
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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
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
