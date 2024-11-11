package com.ps;

public class Topping implements Product{
    private String name;
    private String type;
    private double price;
    private boolean hasExtra;

    public Topping(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public Topping(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Topping(String name, String type, double price, boolean hasExtra) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.hasExtra = hasExtra;
    }

    public double getPrice() {
        return 0;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean hasExtra() {
        return hasExtra;
    }

    public void setHasExtra(boolean hasExtra) {
        this.hasExtra = hasExtra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}