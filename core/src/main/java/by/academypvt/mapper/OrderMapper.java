package by.academypvt.mapper;

import by.academypvt.domain.entity.Order;
import by.academypvt.dto.order.OrderRequest;
import by.academypvt.dto.order.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class OrderMapper {
    UserMapper userMapper = new UserMapperImpl();
    PizzaOrderMapper pizzaOrderMapper = new PizzaOrderMapper();
    SauceOrderMapper sauceOrderMapper = new SauceOrderMapper();

    public OrderResponse toResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setUserId(userMapper.toResponse(order.getUserId()));
        orderResponse.setState(order.getState());
        orderResponse.setDeliveryType(order.getDeliveryType());
        orderResponse.setCost(order.getCost());
        orderResponse.setComment(order.getComment());
        orderResponse.setPizzas(order.getPizzas().stream().map(pizzaOrderMapper::toResponse).collect(Collectors.toList()));
        orderResponse.setSauces(order.getSauces().stream().map(sauceOrderMapper::toResponse).collect(Collectors.toList()));
        return orderResponse;
    }
}
