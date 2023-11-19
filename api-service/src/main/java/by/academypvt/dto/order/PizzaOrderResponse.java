package by.academypvt.dto.order;

import by.academypvt.dto.ingredient.IngredientResponse;
import by.academypvt.dto.pizza.PizzaResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PizzaOrderResponse {
    private PizzaResponse pizza;
    private Long count;
    private IngredientResponse ingredient;

}
