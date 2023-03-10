package com.wafo.jpalecture.order.adapter.out.persistence;

import com.wafo.jpalecture.order.domain.Product;
import jakarta.persistence.*;

@Entity(name = "forOrder")
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
