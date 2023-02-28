package com.wafo.jpalecture.order.application;

import com.wafo.jpalecture.order.application.dto.CreateOrderResponse;
import com.wafo.jpalecture.order.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderResponseGenerator {

    public CreateOrderResponse generateCreateOrderResponse(Order persistOrder) {
        List<Long> productIds = persistOrder.getProducts().getIds();
        int totalAmount = persistOrder.getTotalAmount();
        return new CreateOrderResponse(productIds, totalAmount);
    }
}
