package by.academypvt.dto.sauce;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SauceResponse {
    private Long id;
    private String name;
    private BigDecimal cost;
}
