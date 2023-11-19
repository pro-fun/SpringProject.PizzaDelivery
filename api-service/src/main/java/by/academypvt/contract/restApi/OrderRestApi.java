package by.academypvt.contract.restApi;

import by.academypvt.dto.ingredient.IngredientRequest;
import by.academypvt.dto.order.PizzaOrderRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.dto.order.SauceOrderRequest;
import by.academypvt.dto.pizza.IngredientPizzaRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("order")
public interface OrderRestApi {
    @PostMapping("/addPizzaToOrder")
    public OrderResponse addPizzaToOrder(@RequestBody @Validated PizzaOrderRequest pizzaOrderRequest);
    @PostMapping("/addSauceToOrder")
    public OrderResponse addSauceToOrder(@RequestBody @Validated SauceOrderRequest sauceOrderRequest);
    @PostMapping("/addIngredientToPizza")
    public OrderResponse addIngredientToPizza(@RequestBody @Validated IngredientPizzaRequest ingredientPizzaRequest);
}
