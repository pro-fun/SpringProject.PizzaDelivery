package by.academypvt.dto.order;

import by.academypvt.dto.order.Enums.DeliveryType;
import by.academypvt.dto.order.Enums.Size;
import by.academypvt.dto.order.Enums.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
public class OrderPizzaRequest {

    private Long orderId;
    @NotEmpty
    private String name;
    @NotEmpty
    private Size size;
    @NotEmpty
    @Positive
    private Long count;
}
