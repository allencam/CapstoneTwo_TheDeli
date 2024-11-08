package com.ps;

public class Topping {
    private String name;
    private String type;
    double price;
    private boolean extraMeat;
    private boolean extraCheese;

    public Topping(String name, String type, double price, boolean extraMeat, boolean extraCheese) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.extraMeat = extraMeat;
        this.extraCheese = extraCheese;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
