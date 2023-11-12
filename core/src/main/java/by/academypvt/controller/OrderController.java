package by.academypvt.controller;

import by.academypvt.contract.OrderApi;
import by.academypvt.dto.order.OrderPizzaRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.dto.order.OrderSauceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderApi orderService;

    @PostMapping("/addPizzaToOrder")
    public OrderResponse addPizzaToOrder(@RequestBody @Validated OrderPizzaRequest orderPizzaRequest){
        return orderService.addPizzaToOrder(orderPizzaRequest);
    }
    @PostMapping("/addSauceToOrder")
    public OrderResponse addSauceToOrder(@RequestBody @Validated OrderSauceRequest orderSauceRequest){
        return orderService.addSauceToOrder(orderSauceRequest);
    }
}
