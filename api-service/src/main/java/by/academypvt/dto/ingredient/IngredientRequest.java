package by.academypvt.dto.ingredient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class IngredientRequest {
    @NotBlank
    private String name;
    @Positive
    private Long count;
}
