package com.ps;

import java.util.ArrayList;

public class Sandwich implements Product{
    private String name;
    private String breadType;
    private byte size;
    private boolean isToasted;
    private ArrayList<Topping> toppings;
    private double price;
    private boolean extraMeat;
    private boolean extraCheese;

    public Sandwich(String breadType, byte size) {
        this.name = "Custom Sandwich";
        this.breadType = breadType;
        this.size = size;
        this.isToasted = false;
        this.toppings = new ArrayList<>();
        this.price = getPrice();
    }

    @Override
    public double getPrice() {
        return 0;
    }

    // TODO: Methods for handling sandwich edits
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public static void removeTopping(){}

    public static void editDetails(){} // FOR EDITING BREAD TYPE, SIZE, TOASTINESS

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public byte getSize() {
        return size;
    }

    public void setSize(byte size) {
        this.size = size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f | %s, %d\" | Toppings: %s",name, price, breadType, size, toppings);
    }
}
