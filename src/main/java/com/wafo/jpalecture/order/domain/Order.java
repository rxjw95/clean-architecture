package com.wafo.jpalecture.order.domain;

import java.util.List;

public class Order {
    private Long orderId;
    private List<Product> products;
    private int totalAmount;

    public static Order withoutId(List<Product> products) {
        return new Order(products);
    }

    public static Order withId(Long orderId, List<Product> products) {
        return new Order(orderId, products);
    }

    private Order(Long orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.totalAmount = calculateProductPriceAmount();
    }

    private Order(List<Product> products) {
        this.products = products;
        this.totalAmount = calculateProductPriceAmount();
    }

    private int calculateProductPriceAmount() {
        return this.products.stream().map(Product::getMoney).mapToInt(Integer::valueOf).sum();
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
