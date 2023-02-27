package com.wafo.jpalecture.order.application;

import com.wafo.jpalecture.order.application.port.dto.CreateOrderCommand;
import com.wafo.jpalecture.order.application.port.dto.CreateOrderResponse;
import com.wafo.jpalecture.order.application.port.in.CreateOrderUseCase;
import com.wafo.jpalecture.order.application.port.out.CreateOrderPersistencePort;
import com.wafo.jpalecture.order.application.port.out.CreateOrderResponsePort;
import com.wafo.jpalecture.order.application.port.vo.Products;
import com.wafo.jpalecture.order.domain.Order;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderService implements CreateOrderUseCase {

    private final CreateOrderPersistencePort createOrderPersistencePort;
    private final CreateOrderResponsePort createOrderResponsePort;

    public CreateOrderService(CreateOrderPersistencePort createOrderPersistencePort, CreateOrderResponsePort createOrderResponsePort) {
        this.createOrderPersistencePort = createOrderPersistencePort;
        this.createOrderResponsePort = createOrderResponsePort;
    }

    @Override
    @Transactional
    public CreateOrderResponse execute(CreateOrderCommand command) {
        Order order = createOrderPersistencePort.execute(command);
        Products products = Products.from(order.getProducts());
        products.validateProductCount(command.getProductIds().size());

        return createOrderResponsePort.execute(order);
    }
}
