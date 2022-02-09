package ru.vsu.cs.course1;

public class Planshet {
    public String name;
    public int memory;
    public int rating;
    public int price;

    public Planshet(String name, int memory, int rating, int price) {
        this.name = name;
        this.memory = memory;
        this.rating = rating;
        this.price = price;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
