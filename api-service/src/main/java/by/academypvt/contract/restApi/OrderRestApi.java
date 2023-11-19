package by.academypvt.contract.restApi;

import by.academypvt.dto.comment.CommentRequest;
import by.academypvt.dto.ingredient.IngredientRequest;
import by.academypvt.dto.order.OrderDeliveryRequest;
import by.academypvt.dto.order.PizzaOrderRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.dto.order.SauceOrderRequest;
import by.academypvt.dto.pizza.IngredientPizzaRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("order")
public interface OrderRestApi {
    @PostMapping("/addPizzaToOrder")
    OrderResponse addPizzaToOrder(@RequestBody @Validated PizzaOrderRequest pizzaOrderRequest);
    @PostMapping("/addSauceToOrder")
    OrderResponse addSauceToOrder(@RequestBody @Validated SauceOrderRequest sauceOrderRequest);
    @PostMapping("/addIngredientToPizza")
    OrderResponse addIngredientToPizza(@RequestBody @Validated IngredientPizzaRequest ingredientPizzaRequest);
    @GetMapping("/createOrder")
    OrderResponse createOrder();
    @PostMapping("/addCommentToOrder")
    OrderResponse addCommentToOrder(@RequestBody CommentRequest commentRequest);
    @PostMapping("/toChangeOrderDelivery")
    OrderResponse toChangeOrderDelivery(@RequestBody OrderDeliveryRequest orderDeliveryRequest);
    @DeleteMapping("/deletePizzaFromOrder")
    OrderResponse deletePizzaFromOrder(@RequestBody PizzaOrderRequest pizzaOrderRequest);
    @DeleteMapping("/deleteSauceFromOrder")
    OrderResponse deleteSauceFromOrder(@RequestBody SauceOrderRequest sauceOrderRequest);
    @DeleteMapping("/deleteIngredientFromPizza")
    OrderResponse deleteIngredientFromPizza(@RequestBody IngredientPizzaRequest ingredientPizzaRequest);

}
