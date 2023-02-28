package com.wafo.jpalecture.order.application.port.out;

import com.wafo.jpalecture.order.application.dto.CreateOrderResponse;
import com.wafo.jpalecture.order.domain.Order;

public interface CreateOrderResponsePort {

    CreateOrderResponse execute(Order order);
}
