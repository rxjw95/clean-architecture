package com.wafo.jpalecture.order.application.command;

import java.util.List;

public class CreateOrderCommand {
    private List<Long> productIds;

    public List<Long> getProductIds() {
        return productIds;
    }
}
