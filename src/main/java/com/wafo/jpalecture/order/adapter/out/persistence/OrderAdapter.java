package com.wafo.jpalecture.order.adapter.out.persistence;

import com.wafo.jpalecture.order.application.outport.CreateOrderPort;
import com.wafo.jpalecture.order.domain.Products;
import com.wafo.jpalecture.order.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderAdapter implements CreateOrderPort {

    private final DataJpaOrderRepository jpaOrderRepository;
    private final DataJpaProductRepository jpaProductRepository;

    public OrderAdapter(DataJpaOrderRepository jpaOrderRepository, DataJpaProductRepository jpaProductRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Order create(Order order) {
        Products products = order.getProducts();
        List<ProductEntity> productEntities = jpaProductRepository.findAllById(products.getIds());

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.addAll(productEntities);

        OrderEntity savedOrderEntity = jpaOrderRepository.save(orderEntity);
        return savedOrderEntity.mapToDomain();
    }
}
