package com.wafo.jpalecture.product.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("forProduct")
public interface DataJpaProductRepository extends JpaRepository<ProductEntity, Long> {
}
