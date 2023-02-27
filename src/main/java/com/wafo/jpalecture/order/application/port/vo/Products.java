package com.wafo.jpalecture.order.application.port.vo;

import com.wafo.jpalecture.order.domain.Product;
import com.wafo.jpalecture.order.exeption.IllegalProductCountException;

import java.util.List;

public class Products {
    private final List<Product> entities;

    public static Products from(List<Product> entities) {
        return new Products(entities);
    }

    private Products(List<Product> entities) {
        this.entities = entities;
    }

    public void validateProductCount(int productCount) {
        if(entities.size() != productCount){
            throw new IllegalProductCountException(String.format("ordered product count is %d, but checked product count is %d.", productCount, entities.size()));
        }
    }
}
