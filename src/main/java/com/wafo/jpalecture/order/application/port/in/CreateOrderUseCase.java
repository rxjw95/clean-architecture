package com.wafo.jpalecture.order.application.port.in;

import com.wafo.jpalecture.order.application.command.CreateOrderCommand;
import com.wafo.jpalecture.order.application.dto.CreateOrderResponse;

public interface CreateOrderUseCase {
    CreateOrderResponse execute(CreateOrderCommand command);
}
