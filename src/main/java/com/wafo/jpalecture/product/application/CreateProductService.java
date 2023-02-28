package com.wafo.jpalecture.product.application;

import com.wafo.jpalecture.product.domain.Product;
import com.wafo.jpalecture.product.application.command.CreateProductCommand;
import com.wafo.jpalecture.product.application.command.CreateProductsCommand;
import com.wafo.jpalecture.product.application.dto.CreateProductResponse;
import com.wafo.jpalecture.product.application.dto.CreateProductsResponse;
import com.wafo.jpalecture.product.application.inport.CreateProductUseCase;
import com.wafo.jpalecture.product.application.outport.CreateProductPort;
import com.wafo.jpalecture.product.domain.Products;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateProductService implements CreateProductUseCase {

    private final CreateProductPort createProductPort;

    public CreateProductService(CreateProductPort createProductPort) {
        this.createProductPort = createProductPort;
    }

    @Transactional
    @Override
    public CreateProductResponse registerProduct(CreateProductCommand command) {
        Product product = Product.withoutId(command.getProductName(), command.getPrice());
        Product productPersisted = createProductPort.create(product);
        CreateProductResponse createProductResponse = new CreateProductResponse(productPersisted.getProductId());
        return createProductResponse;
    }

    @Transactional
    @Override
    public CreateProductsResponse registerProducts(CreateProductsCommand request) {
        List<Product> products = request.getProductInfos().stream()
                .map(productInfo -> Product.withoutId(productInfo.getProductName(), productInfo.getPrice()))
                .toList();
        Products productsWrap = Products.from(products);
        Products productsPersisted = createProductPort.create(productsWrap);
        CreateProductsResponse createProductsResponse = new CreateProductsResponse(productsPersisted.getProductIds());
        return createProductsResponse;
    }

}
