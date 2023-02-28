package com.wafo.jpalecture.product.domain;


import com.wafo.jpalecture.exeption.IllegalProductCountException;

import java.util.List;

public class Products {
    private final List<Product> products;

    public static Products from(List<Product> products) {
        return new Products(products);
    }

    private Products(List<Product> products) {
        validateProductCount(products);
        this.products = products;
    }

    private void validateProductCount(List<Product> products) {
        if(products.isEmpty()){
            throw new IllegalProductCountException("product count must be more than 1");
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Long> getProductIds() {
        return products.stream().map(Product::getProductId).toList();
    }
}
