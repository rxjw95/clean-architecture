package com.wafo.jpalecture.order.application.command;

import java.util.List;

public class CreateOrderCommand {
    private List<ProductInfo> productInfos;

    public static class ProductInfo {
        private Long productId;
        private String productName;
        private Integer price;

        private ProductInfo() {}

        public Long getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public Integer getPrice() {
            return price;
        }
    }

    protected CreateOrderCommand() {}

    public List<ProductInfo> getProductInfos() {
        return productInfos;
    }
}
