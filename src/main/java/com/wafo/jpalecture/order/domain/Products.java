package com.wafo.jpalecture.order.domain;

import com.wafo.jpalecture.order.exeption.IllegalProductCountException;

import java.util.List;

public class Products {
    private final List<Product> products;

    public static Products from(List<Product> entities) {
        return new Products(entities);
    }

    private Products(List<Product> products) {
        this.products = products;
    }

    public int calculatePriceAmount() {
        return products.stream().map(Product::getPrice).mapToInt(Integer::valueOf).sum();
    }

    public void validateProductCount() {
        if(products.isEmpty()){
            throw new IllegalProductCountException("product count must be more than 1");
        }
    }

    public List<Long> getIds() {
        return products.stream().mapToLong(Product::getProductId).boxed().toList();
    }

}
