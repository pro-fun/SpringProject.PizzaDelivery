package by.academypvt.controller;

import by.academypvt.contract.restApi.OrderRestApi;
import by.academypvt.contract.serviceApi.OrderApi;
import by.academypvt.dto.ingredient.IngredientRequest;
import by.academypvt.dto.order.PizzaOrderRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.dto.order.SauceOrderRequest;
import by.academypvt.dto.pizza.IngredientPizzaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderRestApi {
    private final OrderApi orderService;


    public OrderResponse addPizzaToOrder(PizzaOrderRequest pizzaOrderRequest){
        return orderService.addPizzaToOrder(pizzaOrderRequest);
    }

    public OrderResponse addSauceToOrder(SauceOrderRequest sauceOrderRequest){
        return orderService.addSauceToOrder(sauceOrderRequest);
    }

    @Override
    public OrderResponse addIngredientToPizza(IngredientPizzaRequest ingredientPizzaRequest) {
        return orderService.addIngredientToPizza(ingredientPizzaRequest);
    }
}
