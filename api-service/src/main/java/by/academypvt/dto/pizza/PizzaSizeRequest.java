package by.academypvt.dto.pizza;

import by.academypvt.dto.enums.Size;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PizzaSizeRequest {
    @NotNull
    private Size size;
}
