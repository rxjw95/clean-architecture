package com.wafo.jpalecture.order.application.outport;

import com.wafo.jpalecture.order.application.dto.CreateProductResponse;
import com.wafo.jpalecture.order.domain.Product;

public interface CreateProductResponsePort {

    CreateProductResponse execute(Product product);
}