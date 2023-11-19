package by.academypvt.controller;

import by.academypvt.contract.restApi.UserRestApi;
import by.academypvt.contract.serviceApi.OrderApi;
import by.academypvt.dto.order.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserRestApi {
    private final OrderApi orderService;

    @Override
    public List<OrderResponse> userOrders() {
        return orderService.getUserOrders();
    }
}
