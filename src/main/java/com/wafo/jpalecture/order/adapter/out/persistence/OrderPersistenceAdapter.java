package com.wafo.jpalecture.order.adapter.out.persistence;

import com.wafo.jpalecture.order.application.port.dto.CreateOrderCommand;
import com.wafo.jpalecture.order.application.port.out.CreateOrderPersistencePort;
import com.wafo.jpalecture.order.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderPersistenceAdapter implements CreateOrderPersistencePort {

    private final SpringDataJpaOrderRepository jpaOrderRepository;
    private final SpringDataJpaProductRepository jpaProductRepository;

    public OrderPersistenceAdapter(SpringDataJpaOrderRepository jpaOrderRepository, SpringDataJpaProductRepository jpaProductRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Order execute(CreateOrderCommand command) {
        List<ProductEntity> productEntities = jpaProductRepository.findAllById(command.getProductIds());

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.addAll(productEntities);

        OrderEntity savedOrderEntity = jpaOrderRepository.save(orderEntity);
        return savedOrderEntity.mapToDomain();
    }
}
