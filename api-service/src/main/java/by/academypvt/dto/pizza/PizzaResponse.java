package by.academypvt.dto.pizza;

import by.academypvt.dto.enums.Size;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class PizzaResponse {
    private Long id;
    private String name;
    private Size size;
    private BigDecimal cost;
}
