package com.wafo.jpalecture.product.application.port.out;

import com.wafo.jpalecture.product.domain.Product;
import com.wafo.jpalecture.product.domain.Products;

import java.util.List;

public interface CreateProductPort {

    Product create(Product product);
    Products create(Products products);
}
