package com.wafo.jpalecture.order.application.port.command;

public class CreateProductCommand {

    private String productName;
    private int price;

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }
}
