package by.academypvt.controller;

import by.academypvt.contract.restApi.OrderRestApi;
import by.academypvt.contract.serviceApi.OrderApi;
import by.academypvt.dto.comment.CommentRequest;
import by.academypvt.dto.order.OrderDeliveryRequest;
import by.academypvt.dto.order.PizzaOrderRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.dto.order.SauceOrderRequest;
import by.academypvt.dto.pizza.IngredientPizzaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderRestApi {
    private final OrderApi orderService;

    @Override
    public OrderResponse addPizzaToOrder(PizzaOrderRequest pizzaOrderRequest){
        return orderService.addPizzaToOrder(pizzaOrderRequest);
    }
    @Override
    public OrderResponse addSauceToOrder(SauceOrderRequest sauceOrderRequest){
        return orderService.addSauceToOrder(sauceOrderRequest);
    }

    @Override
    public OrderResponse addIngredientToPizza(IngredientPizzaRequest ingredientPizzaRequest) {
        return orderService.addIngredientToPizza(ingredientPizzaRequest);
    }

    @Override
    public OrderResponse createOrder() {
        return orderService.createOrder();
    }

    @Override
    public OrderResponse addCommentToOrder(CommentRequest commentRequest) {
        return orderService.addCommentToOrder(commentRequest);
    }

    @Override
    public OrderResponse toChangeOrderDelivery(OrderDeliveryRequest orderDeliveryRequest) {
        return orderService.toChangeOrderDelivery(orderDeliveryRequest);
    }

    @Override
    public OrderResponse deletePizzaFromOrder(PizzaOrderRequest pizzaOrderRequest) {
        return orderService.deletePizzaFromOrder(pizzaOrderRequest);
    }

    @Override
    public OrderResponse deleteSauceFromOrder(SauceOrderRequest sauceOrderRequest) {
        return orderService.deleteSauceFromOrder(sauceOrderRequest);
    }

    @Override
    public OrderResponse deleteIngredientFromPizza(IngredientPizzaRequest ingredientPizzaRequest) {
        return orderService.deleteIngredientFromPizza(ingredientPizzaRequest);
    }
}
