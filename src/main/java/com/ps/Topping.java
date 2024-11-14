package com.ps;

import java.util.List;

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

    public double getPrice(Sandwich sandwich) { 
        byte sandwichSize = sandwich.getSize();

        if (this.type.equals("cheese")) {
            if (hasExtra) { // Extra cheese prices
                return switch (sandwichSize) {
                    case 4 -> 0.75;
                    case 8 -> 1.50;
                    case 12 -> 2.25;
                    default -> throw new IllegalStateException("Unexpected value: " + sandwichSize);
                };
            } else { // Normal cheese prices
                return switch (sandwichSize) {
                    case 4 -> 0.75;
                    case 8 -> 1.50;
                    case 12 -> 2.25;
                    default -> throw new IllegalStateException("Unexpected value: " + sandwichSize);
                };
            }
        } else if (this.type.equals("meat")) {
            if (hasExtra) { // Extra meat prices
                return switch (sandwichSize) {
                    case 4 -> 0.50;
                    case 8 -> 1.00;
                    case 12 -> 1.50;
                    default -> throw new IllegalStateException("Unexpected value: " + sandwichSize);
                };
            } else { // Normal meat prices
                return switch (sandwichSize) {
                    case 4 -> 1.00;
                    case 8 -> 2.00;
                    case 12 -> 3.00;
                    default -> throw new IllegalStateException("Unexpected value: " + sandwichSize);
                };
            }
        }
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
        return hasExtra ? "+" + name : name;
    }
}