package com.wafo.jpalecture.order.application;

import com.wafo.jpalecture.order.application.command.CreateProductCommand;
import com.wafo.jpalecture.order.application.dto.CreateProductResponse;
import com.wafo.jpalecture.order.application.inport.CreateProductUseCase;
import com.wafo.jpalecture.order.application.outport.CreateProductPort;
import com.wafo.jpalecture.order.application.outport.CreateProductResponsePort;
import com.wafo.jpalecture.order.domain.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements CreateProductUseCase {

    private final CreateProductPort createProductPort;
    private final CreateProductResponsePort responsePort;

    public CreateProductService(CreateProductPort createProductPort, CreateProductResponsePort responsePort) {
        this.createProductPort = createProductPort;
        this.responsePort = responsePort;
    }

    @Transactional
    @Override
    public CreateProductResponse registerProduct(CreateProductCommand command) {
        Product product = Product.withoutId(command.getProductName(), command.getPrice());
        Product productPersisted = createProductPort.create(product);
        CreateProductResponse createProductResponse = new CreateProductResponse(productPersisted.getProductId());
        return createProductResponse;
    }

}
