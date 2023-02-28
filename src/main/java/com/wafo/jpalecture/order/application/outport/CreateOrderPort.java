package com.wafo.jpalecture.order.application.outport;

import com.wafo.jpalecture.order.domain.Order;

public interface CreateOrderPort {
    Order create(Order command);
}
