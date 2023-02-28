package com.wafo.jpalecture.order.application.inport;

import com.wafo.jpalecture.order.application.command.CreateProductCommand;
import com.wafo.jpalecture.order.application.dto.CreateProductResponse;

public interface CreateProductUseCase {

    CreateProductResponse registerProduct(CreateProductCommand command);

}
