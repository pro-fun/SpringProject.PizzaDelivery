package by.academypvt.dto.pizza;

import by.academypvt.dto.enums.Size;
import lombok.Data;

@Data
public class IngredientPizzaRequest {
    private String name;
    private Size size;
    private String ingredient_name;
    private Long count;
}
