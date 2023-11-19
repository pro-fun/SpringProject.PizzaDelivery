package by.academypvt.dto.ingredient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class IngredientRequest {
    @NotBlank
    private String name;
    @Positive
    private Long count;
}
