package by.academypvt.dto.pizza;

import by.academypvt.dto.enums.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PizzaRequest {
    @NotBlank
    private String name;
    @NotNull
    private Size size;
    @Positive
    @NotNull
    private BigDecimal cost;
}
