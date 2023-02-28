package com.wafo.jpalecture.order.application.port.in;

import com.wafo.jpalecture.order.application.port.command.CreateProductCommand;
import com.wafo.jpalecture.order.application.dto.CreateProductResponse;

public interface CreateProductUseCase {

    CreateProductResponse registerProduct(CreateProductCommand command);

}
