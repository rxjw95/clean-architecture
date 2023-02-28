package com.wafo.jpalecture.order.adapter.in.web;

import com.wafo.jpalecture.order.application.command.CreateOrderCommand;
import com.wafo.jpalecture.order.application.inport.CreateOrderUseCase;
import com.wafo.jpalecture.order.application.dto.CreateOrderResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateOrderController  {

    private final CreateOrderUseCase createOrderUseCase;


    public CreateOrderController(CreateOrderUseCase createOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
    }

    @PostMapping("/order")
    public CreateOrderResponse order(@RequestBody CreateOrderCommand command) {
        return createOrderUseCase.execute(command);
    }
}
