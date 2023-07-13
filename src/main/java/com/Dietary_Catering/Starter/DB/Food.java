package com.Dietary_Catering.Starter.DB;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Accessors(chain = true)
@ToString
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String imgLink;

    @Column
    private String nameDiet;

    @Column
    private String nameDisplay;

    @Column
    private int price;

    @Column(length = 500)
    private String description;

    public Food() {

    }

    public Food(String nameDiet, String nameDisplay, int price, String description) {
        this.nameDiet = nameDiet;
        this.nameDisplay = nameDisplay;
        this.price = price;
        this.description = description;
    }

    public String getInfoProduct() {
        return String.format("Produkt o id:%d \n Nazwa diety: %s \n Cena: %s", id, nameDisplay, price);
    }
}
