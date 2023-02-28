package com.wafo.jpalecture.order.domain;

public class Order {
    private Long orderId;
    private Products products;
    private int totalAmount;

    public static Order withoutId(Products products) {
        return new Order(products);
    }

    public static Order withId(Long orderId, Products products) {
        return new Order(orderId, products);
    }

    private Order(Long orderId, Products products) {
        this.orderId = orderId;
        this.products = products;
        this.totalAmount = products.calculatePriceAmount();
    }

    private Order(Products products) {
        this.products = products;
    }

    public Products getProducts() {
        return products;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
