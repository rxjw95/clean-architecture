package com.wafo.jpalecture.order.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("forOrder")
public interface SpringDataJpaProductRepository extends JpaRepository<ProductEntity, Long> {
}
