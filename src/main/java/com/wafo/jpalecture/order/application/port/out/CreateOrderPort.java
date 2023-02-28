package com.wafo.jpalecture.order.application.port.out;

import com.wafo.jpalecture.order.domain.Order;

public interface CreateOrderPort {
    Order create(Order command);
}
