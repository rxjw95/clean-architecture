package com.wafo.jpalecture.product.application.port.in;

import com.wafo.jpalecture.product.application.command.CreateProductCommand;
import com.wafo.jpalecture.product.application.command.CreateProductsCommand;
import com.wafo.jpalecture.product.application.dto.CreateProductResponse;
import com.wafo.jpalecture.product.application.dto.CreateProductsResponse;

public interface CreateProductUseCase {

    CreateProductResponse registerProduct(CreateProductCommand command);

    CreateProductsResponse registerProducts(CreateProductsCommand request);
}
