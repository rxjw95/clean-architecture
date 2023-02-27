package com.wafo.jpalecture.order.application.port.out;

import com.wafo.jpalecture.order.application.port.dto.CreateOrderCommand;
import com.wafo.jpalecture.order.domain.Order;

public interface CreateOrderPersistencePort {
    Order execute(CreateOrderCommand command);
}
