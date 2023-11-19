package by.academypvt.dto.ingredient;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class IngredientResponse {
    private Long id;
    private String name;
    private BigDecimal cost;
}
