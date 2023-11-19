package by.academypvt.dto.sauce;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SauceRequest {
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private BigDecimal cost;
}
