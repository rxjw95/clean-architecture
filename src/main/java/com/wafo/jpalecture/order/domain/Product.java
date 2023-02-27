package com.wafo.jpalecture.order.domain;

public class Product {

    private Long productId;
    private String productName;
    private int money;

    public static Product withoutId(String productName, int money) {
        return new Product(productName, money);
    }

    public static Product withId(Long productId, String productName, int money) {
        return new Product(productId, productName, money);
    }

    private Product(String productName, int money) {
        this.productName = productName;
        this.money = money;
    }

    private Product(Long productId, String productName, int money) {
        this.productId = productId;
        this.productName = productName;
        this.money = money;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getMoney() {
        return money;
    }
}
