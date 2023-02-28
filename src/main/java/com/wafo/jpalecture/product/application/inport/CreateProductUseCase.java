package com.wafo.jpalecture.product.application.inport;

import com.wafo.jpalecture.product.application.command.CreateProductCommand;
import com.wafo.jpalecture.product.application.command.CreateProductsCommand;
import com.wafo.jpalecture.product.application.dto.CreateProductResponse;
import com.wafo.jpalecture.product.application.dto.CreateProductsResponse;

public interface CreateProductUseCase {

    CreateProductResponse registerProduct(CreateProductCommand command);

    CreateProductsResponse registerProducts(CreateProductsCommand request);
}
