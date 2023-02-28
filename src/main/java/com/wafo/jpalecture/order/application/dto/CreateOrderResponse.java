package com.wafo.jpalecture.order.application.dto;

import java.util.List;

public class CreateOrderResponse {
    private final List<Long> productIds;
    private final int totalAmount;

    public CreateOrderResponse(List<Long> productIds, int totalAmount) {
        this.productIds = productIds;
        this.totalAmount = totalAmount;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
