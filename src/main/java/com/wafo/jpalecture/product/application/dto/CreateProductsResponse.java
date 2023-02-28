package com.wafo.jpalecture.product.application.dto;

import java.util.List;

public class CreateProductsResponse {
    private final List<Long> productIds;

    public CreateProductsResponse(List<Long> productIds) {
        this.productIds = productIds;
    }

    public List<Long> getProductIds() {
        return productIds;
    }
}
