package by.academypvt.dto.order;

import by.academypvt.dto.sauce.SauceResponse;
import lombok.Data;

@Data
public class SauceOrderResponse {

    private SauceResponse sauce;
    private Long count;
}
