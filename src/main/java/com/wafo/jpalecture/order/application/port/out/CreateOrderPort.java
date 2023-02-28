package com.wafo.jpalecture.order.application.port.out;

import com.wafo.jpalecture.order.domain.Order;

import java.util.List;

public interface CreateOrderPort {
    Order create(List<Long> command);
}
