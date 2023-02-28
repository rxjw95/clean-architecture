package com.wafo.jpalecture.product.adapter.out.persistence;

import com.wafo.jpalecture.product.domain.Product;
import jakarta.persistence.*;

@Entity(name = "forProduct")
@Table(name = "product")
@Access(AccessType.FIELD)
public class ProductEntity {
    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private int price;

    public ProductEntity(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public Product mapToDomain() {
        return Product.withId(this.productId, this.productName, this.price);
    }

    protected ProductEntity() {}

}
