package by.academypvt.mapper;

import by.academypvt.domain.entity.Order;
import by.academypvt.domain.entity.User;
import by.academypvt.dto.order.OrderRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.dto.user.UserRequest;

public class OrderMapper {
    public Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order(orderRequest.getOrderTime(),orderRequest.getCost(),orderRequest.getState(),orderRequest.getDeliveryType());
        return order;
    }

    public OrderResponse mapFromOrder(Order order){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setOrderTime(order.getOrderTime());
        orderResponse.setCost(order.getCost());
        orderResponse.setState(order.getState());
        orderResponse.setDeliveryType(order.getDeliveryType());
        return orderResponse;
    }
}
