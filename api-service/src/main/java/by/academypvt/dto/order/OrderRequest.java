package by.academypvt.dto.order;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {


    private String orderTime;
    private State state;
    private DeliveryType deliveryType;
    private Float cost;

}
