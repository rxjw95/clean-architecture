package com.wafo.jpalecture.order.adapter.out.persistence;

import com.wafo.jpalecture.order.domain.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
@Access(AccessType.FIELD)
public class ProductEntity {
    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private int money;

    public ProductEntity(String productName, int money) {
        this.productName = productName;
        this.money = money;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getMoney() {
        return money;
    }

    public Product mapToDomain() {
        return Product.withId(this.productId, this.productName, this.money);
    }

    protected ProductEntity() {}

}
