package com.wafo.jpalecture.order.application.port.dto;

import java.util.List;

public class CreateOrderCommand {
    private List<Long> productIds;

    public CreateOrderCommand(List<Long> productIds) {
        this.productIds = productIds;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    protected CreateOrderCommand() {}
}
