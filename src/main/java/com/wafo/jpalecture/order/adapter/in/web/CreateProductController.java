package com.wafo.jpalecture.order.adapter.in.web;

import com.wafo.jpalecture.order.application.command.CreateProductCommand;
import com.wafo.jpalecture.order.application.dto.CreateProductResponse;
import com.wafo.jpalecture.order.application.inport.CreateProductUseCase;
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


}
