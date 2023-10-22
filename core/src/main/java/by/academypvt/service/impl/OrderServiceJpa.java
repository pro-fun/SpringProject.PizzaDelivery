package by.academypvt.service.impl;

import by.academypvt.dto.order.OrderRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.mapper.OrderMapper;
import by.academypvt.repository.OrderRepository;
import by.academypvt.service.OrderService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OrderServiceJpa implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderResponse findOrderById(Long id) {

        return orderMapper.mapFromOrder(orderRepository.findOrderById(id));
    }

    @Override
    public void addOrder(OrderRequest orderRequest) {
        orderRepository.addOrder(orderMapper.mapToOrder(orderRequest));
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteOrderById(id);
    }

    @Override
    public List<OrderResponse> updateOrders() {
        return orderRepository.updateOrders().stream().map(orderMapper::mapFromOrder).collect(Collectors.toList());
    }
}
