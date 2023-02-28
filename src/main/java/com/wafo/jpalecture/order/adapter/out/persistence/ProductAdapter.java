package com.wafo.jpalecture.order.adapter.out.persistence;

import com.wafo.jpalecture.order.application.port.out.CreateProductPort;
import com.wafo.jpalecture.order.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductAdapter implements CreateProductPort {
    private final SpringDataJpaProductRepository jpaProductRepository;

    public ProductAdapter(SpringDataJpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product create(Product product) {
        ProductEntity productEntity = new ProductEntity(product.getProductName(), product.getPrice());
        ProductEntity productSaved = jpaProductRepository.save(productEntity);
        return productSaved.mapToDomain();
    }
}
