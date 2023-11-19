package by.academypvt.dto.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SauceOrderRequest {

    @NotBlank
    private String name;
    @NotNull
    @Positive
    private Long count;
}
