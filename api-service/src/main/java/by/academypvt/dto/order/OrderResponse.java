package by.academypvt.dto.order;

import by.academypvt.dto.order.Enums.DeliveryType;
import by.academypvt.dto.order.Enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OrderResponse {
    private Long id;
    private String orderTime;
    private State state;
    private DeliveryType deliveryType;
    private Float cost;
}
