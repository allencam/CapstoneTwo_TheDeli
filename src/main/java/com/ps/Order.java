package com.ps;

import java.util.ArrayList;

public class Order {
    private short orderId;
    private double total;
    private ArrayList<Product> products;

    public Order(short orderId, double total, ArrayList<Product> products) {
        this.orderId = orderId;
        this.total = total;
        this.products = new ArrayList<>();
    }

    public Order(ArrayList<Product> products) {
        this.products = products;
    }

    public static void createOrder() {}

    public static void reviewOrder() {}

    public static void getOrderTotal(Order order) {}

    public static void submitOrder(Order order) {}

    public static void removeProduct(Product product) {}

    private static void editProduct() {}

    private static void addProduct(Product product) {}

    public short getOrderId() {
        return orderId;
    }

    public void setOrderId(short orderId) {
        this.orderId = orderId;
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
