package by.academypvt.contract.serviceApi;

import by.academypvt.dto.ingredient.IngredientRequest;
import by.academypvt.dto.order.PizzaOrderRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.dto.order.SauceOrderRequest;
import by.academypvt.dto.pizza.IngredientPizzaRequest;

public interface OrderApi {
    OrderResponse addPizzaToOrder(PizzaOrderRequest pizzaOrderRequest);
    OrderResponse addSauceToOrder(SauceOrderRequest sauceOrderRequest);
    OrderResponse addIngredientToPizza(IngredientPizzaRequest ingredientPizzaRequest);
}
