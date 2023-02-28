package com.wafo.jpalecture.product.adapter.in.web;

import com.wafo.jpalecture.product.application.command.CreateProductCommand;
import com.wafo.jpalecture.product.application.command.CreateProductsCommand;
import com.wafo.jpalecture.product.application.dto.CreateProductResponse;
import com.wafo.jpalecture.product.application.dto.CreateProductsResponse;
import com.wafo.jpalecture.product.application.inport.CreateProductUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateProductController {

    private final CreateProductUseCase createProductUseCase;

    public CreateProductController(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    @PostMapping("/product")
    CreateProductResponse register(@RequestBody CreateProductCommand request) {
        return createProductUseCase.registerProduct(request);
    }

    @PostMapping("/products")
    CreateProductsResponse register(@RequestBody CreateProductsCommand request) {
        return createProductUseCase.registerProducts(request);
    }

}
