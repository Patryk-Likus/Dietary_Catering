package com.Dietary_Catering.Starter.DB;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Food {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String imgLink;

    @Column
    private String nameDisplay;

    @Column
    private int price;

    @Column(length = 500)
    private String description;


    public Food(String name, String nameDisplay, int price, String description) {
        this.name = name;
        this.imgLink = name + ".png";
        this.nameDisplay = nameDisplay;
        this.price = price;
        this.description = description;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getNameDisplay() {
        return nameDisplay;
    }

    public void setNameDisplay(String nameDisplay) {
        this.nameDisplay = nameDisplay;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
