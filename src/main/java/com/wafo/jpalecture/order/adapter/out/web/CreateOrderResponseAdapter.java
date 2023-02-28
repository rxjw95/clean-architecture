package com.wafo.jpalecture.order.adapter.out.web;

import com.wafo.jpalecture.order.application.dto.CreateOrderResponse;
import com.wafo.jpalecture.order.application.outport.CreateOrderResponsePort;
import com.wafo.jpalecture.order.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateOrderResponseAdapter implements CreateOrderResponsePort {

    @Override
    public CreateOrderResponse execute(Order order) {
        List<Long> productIds = order.getProducts().getIds();
        int totalAmount = order.getTotalAmount();
        return new CreateOrderResponse(productIds, totalAmount);
    }
}
