package com.wafo.jpalecture.order.adapter.out.web;

import com.wafo.jpalecture.order.application.dto.CreateProductResponse;
import com.wafo.jpalecture.order.application.port.out.CreateProductResponsePort;
import com.wafo.jpalecture.order.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class CreateProductResponseAdapter implements CreateProductResponsePort {


    @Override
    public CreateProductResponse execute(Product product) {
        return new CreateProductResponse(product.getProductId());

    }
}
