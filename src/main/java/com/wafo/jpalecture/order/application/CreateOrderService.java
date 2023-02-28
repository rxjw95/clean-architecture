package com.wafo.jpalecture.order.application;

import com.wafo.jpalecture.order.application.command.CreateOrderCommand;
import com.wafo.jpalecture.order.application.dto.CreateOrderResponse;
import com.wafo.jpalecture.order.application.port.in.CreateOrderUseCase;
import com.wafo.jpalecture.order.application.port.out.CreateOrderPort;
import com.wafo.jpalecture.order.domain.Order;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateOrderService implements CreateOrderUseCase {

    private final CreateOrderPort createOrderPort;
    private final OrderResponseGenerator orderResponseGenerator;

    public CreateOrderService(CreateOrderPort createOrderPort, OrderResponseGenerator orderResponseGenerator) {
        this.createOrderPort = createOrderPort;
        this.orderResponseGenerator = orderResponseGenerator;
    }

    @Override
    @Transactional
    public CreateOrderResponse execute(CreateOrderCommand command) {
        Order order = createOrder(command);
        return orderResponseGenerator.generateCreateOrderResponse(order);
    }

    private Order createOrder(CreateOrderCommand command) {
        List<Long> productIds = command.getProductIds();
        return createOrderPort.create(productIds);
    }
}
