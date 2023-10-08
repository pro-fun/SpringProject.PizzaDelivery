package by.academypvt.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long id;
    private String orderTime;
    private State state;
    private DeliveryType deliveryType;
    private Float cost;
}
