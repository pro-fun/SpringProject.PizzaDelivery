package by.academypvt.dto.order;

import by.academypvt.dto.enums.Size;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
public class PizzaOrderRequest {

    @NotBlank
    private String name;
    @NotNull
    private Size size;
    @NotNull
    @Positive
    private Long count;
}
