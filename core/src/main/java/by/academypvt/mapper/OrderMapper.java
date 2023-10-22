package by.academypvt.mapper;

import by.academypvt.domain.entity.Order;
import by.academypvt.domain.entity.User;
import by.academypvt.dto.order.OrderRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.dto.user.UserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderResponse toResponse(Order order);
    Order toOrder(OrderRequest orderRequest);
}
