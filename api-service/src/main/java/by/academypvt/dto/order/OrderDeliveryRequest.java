package by.academypvt.dto.order;

import by.academypvt.dto.enums.DeliveryType;
import lombok.Data;

@Data
public class OrderDeliveryRequest {
    private DeliveryType deliveryType;
}
