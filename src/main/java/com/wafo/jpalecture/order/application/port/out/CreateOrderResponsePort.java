package com.wafo.jpalecture.order.application.port.out;

import com.wafo.jpalecture.order.application.port.dto.CreateOrderResponse;
import com.wafo.jpalecture.order.domain.Order;

public interface CreateOrderResponsePort {

    CreateOrderResponse response(Order order);
}
