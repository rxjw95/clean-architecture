package com.wafo.jpalecture.order.application;

import com.wafo.jpalecture.order.application.command.CreateOrderCommand;
import com.wafo.jpalecture.order.application.dto.CreateOrderResponse;
import com.wafo.jpalecture.order.application.port.in.CreateOrderUseCase;
import com.wafo.jpalecture.order.application.port.out.CreateOrderPort;
import com.wafo.jpalecture.order.domain.Products;
import com.wafo.jpalecture.order.domain.Order;
import com.wafo.jpalecture.order.domain.Product;
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
        List<CreateOrderCommand.ProductInfo> productInfos = command.getProductInfos();

        List<Product> products = productInfos.stream()
                .map(productInfo -> Product.withId(productInfo.getProductId(), productInfo.getProductName(), productInfo.getPrice()))
                .toList();

        Products productsWrap = Products.from(products);

        Order order = createOrder(productsWrap);

        return orderResponseGenerator.generateCreateOrderResponse(order);
    }

    private Order createOrder(Products products) {
        Order order = Order.withoutId(products);

        return createOrderPort.create(order);
    }
}
