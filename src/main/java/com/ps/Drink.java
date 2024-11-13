package com.ps;

public class Drink implements Product {
    private String name;
    private String size;
    private double price;

    public Drink(String name, String size) {
        this.name = name;
        this.size = size;
        this.price = getPrice();
    }

    @Override
    public double getPrice() {
        return switch (this.size) {
            case "Small" -> 2.00;
            case "Medium" -> 2.50;
            case "Large" -> 3.00;
            default -> 0;
        };
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}