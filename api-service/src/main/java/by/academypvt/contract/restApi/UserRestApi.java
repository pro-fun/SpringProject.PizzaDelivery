package by.academypvt.contract.restApi;

import by.academypvt.dto.order.OrderResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("user")
public interface UserRestApi {
    @GetMapping("/getOrders")
    List<OrderResponse> userOrders();

}
