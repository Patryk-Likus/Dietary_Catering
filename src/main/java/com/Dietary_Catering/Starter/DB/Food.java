package com.Dietary_Catering.Starter.DB;


public class Food {

    private static int count = 1;
    private int idx;
    private String name;
    private String imgLink;
    private String nameDisplay;
    private int price;
    private String description;


    public Food(String name, String nameDisplay, int price, String description) {
        this.name = name;
        this.imgLink = name + ".png";
        this.nameDisplay = nameDisplay;
        this.price = price;
        this.description = description;
        this.idx = count;
        count++;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
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
