package com.ps.structure;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Product {
    private String name;
    private String breadType;
    private byte size;
    private boolean isToasted;
    private ArrayList<Topping> toppings;
    private double price;


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
        double sandwichPrice = switch (this.size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> throw new IllegalStateException("Unexpected value: " + this.size);
        };

        for (Topping topping : toppings) {
            sandwichPrice += topping.getPrice(this);
        }
        return sandwichPrice;
    }

    public void checkForExtraToppings(List<Topping> toppings) {
        int meatCount = 0;
        int cheeseCount = 0;

        for (Topping topping : toppings) {
            if (topping.getType().equals("meat")) {
                meatCount++;
                if (meatCount == 2) {
                    topping.setHasExtra(true);
                } else {
                    topping.setHasExtra(false);
                }
            } else if (topping.getType().equals("cheese")) {
                cheeseCount++;
                if (cheeseCount == 2) {
                    topping.setHasExtra(true);
                } else {
                    topping.setHasExtra(false);
                }
            } else {
                topping.setHasExtra(false);
            }
        }
    }

    // TODO: Methods for handling sandwich edits
    public void addTopping(Topping topping) {
        toppings.add(topping);
        topping.getPrice(this);
    }

    public static void editDetails() {
    } // FOR EDITING BREAD TYPE, SIZE, TOASTINESS

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
        return String.format("%s %s - $%.2f | %s, %d\" | Toppings: %s"
                ,name,isToasted ? "(toasted)" : "(not toasted)",getPrice(),breadType,size,toppings);
    }
}
