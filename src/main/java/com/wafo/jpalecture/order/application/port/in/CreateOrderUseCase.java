package com.wafo.jpalecture.order.application.port.in;

import com.wafo.jpalecture.order.application.port.dto.CreateOrderCommand;
import com.wafo.jpalecture.order.application.port.dto.CreateOrderResponse;

public interface CreateOrderUseCase {
    CreateOrderResponse create(CreateOrderCommand command);
}
