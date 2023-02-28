package com.wafo.jpalecture.product.application.command;

import java.util.List;

public class CreateProductsCommand {

    private List<ProductInfo> productInfos;

    public static class ProductInfo {
        private String productName;
        private Integer price;

        private ProductInfo() {}

        public String getProductName() {
            return productName;
        }

        public Integer getPrice() {
            return price;
        }
    }

    protected CreateProductsCommand() {}

    public List<ProductInfo> getProductInfos() {
        return productInfos;
    }
}
