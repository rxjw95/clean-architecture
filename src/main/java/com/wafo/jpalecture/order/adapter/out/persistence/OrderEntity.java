package com.wafo.jpalecture.order.adapter.out.persistence;

import com.wafo.jpalecture.order.domain.Order;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Access(AccessType.FIELD)
public class OrderEntity {
    @Id
    @GeneratedValue
    private Long orderId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<ProductEntity> productEntities = new ArrayList<>();

    public void add(ProductEntity product) {
        this.productEntities.add(product);
    }

    public void addAll(List<ProductEntity> products) {
        this.productEntities.addAll(products);
    }

    public Long getOrderId() {
        return orderId;
    }

    public List<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public Order mapToDomain() {
        return Order.withId(this.orderId, this.productEntities.stream().map(ProductEntity::mapToDomain).toList());
    }
}
