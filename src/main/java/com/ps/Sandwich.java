package com.ps;

import java.util.ArrayList;

public class Sandwich implements Product{
    private String breadType;
    private byte size;
    private boolean isToasted;
    private ArrayList<Topping> toppings;
    private double price;

    public Sandwich(String breadType, byte size, boolean isToasted, ArrayList<Topping> toppings, double price) {
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
        this.price = price;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    // TODO: Methods for handling sandwich edits
    public static void addTopping(Topping topping) {}

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
}
