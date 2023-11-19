package by.academypvt.dto.pizza;

import by.academypvt.dto.enums.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class PizzaResponse {
    private Long id;
    private String name;
    private Size size;
    private BigDecimal cost;
    private List<IngredientPizzaResponse> ingredients = new ArrayList<>();
}
