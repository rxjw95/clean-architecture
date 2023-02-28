package com.wafo.jpalecture.product.application;

import com.wafo.jpalecture.product.domain.Product;
import com.wafo.jpalecture.product.domain.Products;
import com.wafo.jpalecture.product.application.dto.CreateProductResponse;
import com.wafo.jpalecture.product.application.dto.CreateProductsResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseGenerator {

    public CreateProductResponse generateCreateProductResponse(Product persistProduct) {
        return new CreateProductResponse(persistProduct.getProductId());
    }

    public CreateProductsResponse generateCreateProductsResponse(Products persistProducts) {
        return new CreateProductsResponse(persistProducts.getProductIds());
    }
}
