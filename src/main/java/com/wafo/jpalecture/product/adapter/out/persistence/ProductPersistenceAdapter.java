package com.wafo.jpalecture.product.adapter.out.persistence;

import com.wafo.jpalecture.product.application.port.out.CreateProductPort;
import com.wafo.jpalecture.product.domain.Product;
import com.wafo.jpalecture.product.domain.Products;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductPersistenceAdapter implements CreateProductPort {
    private final DataJpaProductRepository jpaProductRepository;

    public ProductPersistenceAdapter(DataJpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product create(Product product) {
        ProductEntity productEntity = new ProductEntity(product.getProductName(), product.getPrice());
        ProductEntity productSaved = jpaProductRepository.save(productEntity);
        return productSaved.mapToDomain();
    }

    @Override
    public Products create(Products products) {
        List<ProductEntity> productEntities = products.getProducts().stream()
                .map(product -> new ProductEntity(product.getProductName(), product.getPrice()))
                .toList();

        List<ProductEntity> productEntitiesSaved = jpaProductRepository.saveAll(productEntities);

        return Products.from(
                productEntitiesSaved.stream()
                        .map(ProductEntity::mapToDomain)
                        .toList());
    }
}
