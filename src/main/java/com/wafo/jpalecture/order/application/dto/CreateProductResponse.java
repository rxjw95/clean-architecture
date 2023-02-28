package com.wafo.jpalecture.order.application.dto;

public class CreateProductResponse {
    private final Long productId;

    public CreateProductResponse(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
