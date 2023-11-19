package by.academypvt.dto.order;

import by.academypvt.dto.enums.DeliveryType;
import by.academypvt.dto.enums.State;
import by.academypvt.dto.pizza.IngredientPizzaResponse;
import by.academypvt.dto.user.UserResponse;
import lombok.Data;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private UserResponse userId;
    private State state;
    private String orderTime;
    private DeliveryType deliveryType;
    private BigDecimal cost;
    private String comment;
    private List<PizzaOrderResponse> pizzas = new ArrayList<>();
    private List<SauceOrderResponse> sauces = new ArrayList<>();
}
