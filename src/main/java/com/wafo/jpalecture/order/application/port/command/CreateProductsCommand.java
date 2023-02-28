package com.wafo.jpalecture.order.application.port.command;

public class CreateProductsCommand {

    private final String productName;
    private final int price;

    public CreateProductsCommand(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }
}
