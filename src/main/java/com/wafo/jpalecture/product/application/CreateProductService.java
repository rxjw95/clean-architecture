package com.wafo.jpalecture.product.application;

import com.wafo.jpalecture.product.domain.Product;
import com.wafo.jpalecture.product.application.command.CreateProductCommand;
import com.wafo.jpalecture.product.application.command.CreateProductsCommand;
import com.wafo.jpalecture.product.application.dto.CreateProductResponse;
import com.wafo.jpalecture.product.application.dto.CreateProductsResponse;
import com.wafo.jpalecture.product.application.port.in.CreateProductUseCase;
import com.wafo.jpalecture.product.application.port.out.CreateProductPort;
import com.wafo.jpalecture.product.domain.Products;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateProductService implements CreateProductUseCase {

    private final CreateProductPort createProductPort;
    private final ProductResponseGenerator productResponseGenerator;

    public CreateProductService(CreateProductPort createProductPort, ProductResponseGenerator productResponseGenerator) {
        this.createProductPort = createProductPort;
        this.productResponseGenerator = productResponseGenerator;
    }

    @Transactional
    @Override
    public CreateProductResponse registerProduct(CreateProductCommand command) {
        Product product = Product.withoutId(command.getProductName(), command.getPrice());
        Product persistProduct = createProductPort.create(product);
        return productResponseGenerator.generateCreateProductResponse(persistProduct);
    }

    @Transactional
    @Override
    public CreateProductsResponse registerProducts(CreateProductsCommand request) {
        List<Product> products = request.getProductInfos().stream()
                .map(productInfo -> Product.withoutId(productInfo.getProductName(), productInfo.getPrice()))
                .toList();
        Products productsWrap = Products.from(products);
        Products persistProducts = createProductPort.create(productsWrap);
        return productResponseGenerator.generateCreateProductsResponse(persistProducts);
    }

}
