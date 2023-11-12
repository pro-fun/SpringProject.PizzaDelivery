package by.academypvt.dto.pizza;

import by.academypvt.dto.order.Enums.Size;
import lombok.Data;

@Data
public class PizzaResponse {
    private Long id;
    private String name;
    private Size size;
    private Float cost;
}
