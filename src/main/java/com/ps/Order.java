package com.ps;

import java.util.ArrayList;

public class Order {
    private double total;
    private ArrayList<Product> products;

    public Order(double total, ArrayList<Product> products) {
        this.total = total;
        this.products = new ArrayList<>();
    }

    public Order() {
        this.products = new ArrayList<>();
    }

    public static void getOrderTotal(Order order) {}

    public static void submitOrder(Order order) {}

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    private static void editProduct() {}

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
