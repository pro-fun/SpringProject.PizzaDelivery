package by.academypvt.contract;

import by.academypvt.dto.order.OrderPizzaRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.dto.order.OrderSauceRequest;

public interface OrderApi {
    OrderResponse addPizzaToOrder(OrderPizzaRequest orderPizzaRequest);
    OrderResponse addSauceToOrder(OrderSauceRequest orderSauceRequest);
}
