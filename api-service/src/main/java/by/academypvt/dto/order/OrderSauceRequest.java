package by.academypvt.dto.order;

import by.academypvt.dto.order.Enums.Size;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderSauceRequest {
    @NotEmpty
    private Long orderId;
    @NotEmpty
    private String name;
    @NotEmpty
    @Positive
    private Long count;
}
