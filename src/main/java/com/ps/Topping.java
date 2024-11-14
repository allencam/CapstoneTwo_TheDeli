package com.ps;

public class Topping implements Product{
    private String name;
    private String type;
    private double price;
    private boolean hasExtra;

    public Topping(String type) {
        this.type = type;
        this.price = getPrice();
    }

    public Topping(String name, String type) {
        this.name = name;
        this.type = type;
        this.price = getPrice();
    }

    public Topping(String name, String type, boolean hasExtra) {
        this.name = name;
        this.type = type;
        this.price = getPrice();
        this.hasExtra = hasExtra;
    }

    public double getPrice() {
        return 0;
    }

    public double getPrice(Sandwich sandwich) { //
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

    @Override
    public String toString() {
        return name;
    }
}