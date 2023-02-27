package com.wafo.jpalecture.order.adapter.out.web;

import com.wafo.jpalecture.order.application.port.dto.CreateOrderResponse;
import com.wafo.jpalecture.order.application.port.out.CreateOrderResponsePort;
import com.wafo.jpalecture.order.domain.Order;
import com.wafo.jpalecture.order.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateOrderResponseAdapter implements CreateOrderResponsePort {

    @Override
    public CreateOrderResponse response(Order order) {
        List<Long> productIds = order.getProducts().stream().map(Product::getProductId).toList();
        int totalAmount = order.getTotalAmount();
        return new CreateOrderResponse(productIds, totalAmount);
    }
}
