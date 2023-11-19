package by.academypvt.dto.order;

import by.academypvt.dto.pizza.PizzaResponse;
import lombok.Data;

@Data
public class PizzaOrderResponse {
    private PizzaResponse pizza;
    private Long count;

}
