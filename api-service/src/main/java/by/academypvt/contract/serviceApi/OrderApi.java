package by.academypvt.contract.serviceApi;

import by.academypvt.dto.comment.CommentRequest;
import by.academypvt.dto.ingredient.IngredientRequest;
import by.academypvt.dto.order.OrderDeliveryRequest;
import by.academypvt.dto.order.PizzaOrderRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.dto.order.SauceOrderRequest;
import by.academypvt.dto.pizza.IngredientPizzaRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderApi {
    OrderResponse addPizzaToOrder(PizzaOrderRequest pizzaOrderRequest);
    OrderResponse addSauceToOrder(SauceOrderRequest sauceOrderRequest);
    OrderResponse addIngredientToPizza(IngredientPizzaRequest ingredientPizzaRequest);
    OrderResponse createOrder();
    List<OrderResponse> getUserOrders();
    OrderResponse addCommentToOrder(CommentRequest commentRequest);
    OrderResponse toChangeOrderDelivery(@RequestBody OrderDeliveryRequest orderDeliveryRequest);
}
