package com.Dietary_Catering.Starter.DB;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

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

    /*@OneToMany(mappedBy = "food")
    Set<OrderHistory> orderHistory = new HashSet<OrderHistory>();*/



    public Food(String nameDiet, String nameDisplay, int price, String description) {
        this.nameDiet = nameDiet;
        this.imgLink = nameDiet + ".png";
        this.nameDisplay = nameDisplay;
        this.price = price;
        this.description = description;

    }

    public Food() { }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNameDiet() {
        return nameDiet;
    }

    public void setNameDiet(String nameDiet) {
        this.imgLink = nameDiet+".png";
        this.nameDiet = nameDiet;
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

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", nameDiet='" + nameDiet + '\'' +
                ", imgLink='" + imgLink + '\'' +
                ", nameDisplay='" + nameDisplay + '\'' +
                ", price=" + price +
                ", description='" + description + '\''+
                '}';
    }

    public String toString1() {
        return String.format("Produkt o id:%d \n Nazwa diety: %s \n Cena: %s", id, nameDisplay, price);
    }
}
