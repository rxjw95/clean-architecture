package com.wafo.jpalecture.order.application.outport;

import com.wafo.jpalecture.order.domain.Product;

public interface CreateProductPort {

    Product create(Product product);
}
