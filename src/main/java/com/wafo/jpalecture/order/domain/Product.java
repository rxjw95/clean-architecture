package com.wafo.jpalecture.order.domain;

public class Product {

    private Long productId;
    private String productName;
    private int price;

    public static Product withoutId(String productName, int price) {
        return new Product(productName, price);
    }

    public static Product withId(Long productId, String productName, int price) {
        return new Product(productId, productName, price);
    }

    private Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    private Product(Long productId, String productName, int price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }
}
