package com.ps;

public class Chips implements Product {
    private String name;
    private double price;

    public Chips(String name) {
        this.name = name;
        this.price = getPrice();
    }

    @Override
    public double getPrice() {
        return 1.50;
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
