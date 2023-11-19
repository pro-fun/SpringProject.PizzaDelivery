package by.academypvt.dto.pizza;

import by.academypvt.dto.ingredient.IngredientResponse;
import lombok.Data;

@Data
public class IngredientPizzaResponse {
    private IngredientResponse ingredient;
    private Long count;

}
