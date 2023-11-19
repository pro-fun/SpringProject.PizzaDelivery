package by.academypvt.dto.order;

import by.academypvt.dto.enums.DeliveryType;
import by.academypvt.dto.enums.State;
import lombok.Data;

@Data
public class OrderRequest {

    private String orderTime;
    private State state;
    private DeliveryType deliveryType;
    private Float cost;
}
