package com.ps;

public class Drink implements Product {
    private String name;
    private byte size;
    private double price;

    public Drink(String name, byte size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getSize() {
        return size;
    }

    public void setSize(byte size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}