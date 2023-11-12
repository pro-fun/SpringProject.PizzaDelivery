//package by.academypvt.service.impl;
//
//import by.academypvt.domain.entity.Order;
//import by.academypvt.domain.entity.User;
//import by.academypvt.dto.order.OrderRequest;
//import by.academypvt.dto.order.OrderResponse;
//import by.academypvt.mapper.OrderMapper;
//import by.academypvt.repository.OrderRepository;
//import by.academypvt.repository.UserRepository;
//import by.academypvt.service.OrderService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor
//public class OrderServiceJpa implements OrderService {
//    private final UserRepository userRepository;
//    private final OrderRepository orderRepository;
//    private final OrderMapper orderMapper;
//
//    @Override
//    public OrderResponse findOrderById(Long id) {
//
//        return orderMapper.toResponse(orderRepository.findOrderById(id));
//
//    }
//
//    @Override
//    public void addOrder(OrderRequest orderRequest) {
//
//        orderRepository.addOrder(orderMapper.toOrder(orderRequest));
//    }
//
//    @Override
//    public void deleteOrderById(Long id) {
//        orderRepository.deleteOrderById(id);
//    }
//
//    @Override
//    public List<OrderResponse> updateOrders() {
//        return orderRepository.updateOrders().stream().map(orderMapper::toResponse).collect(Collectors.toList());
//    }
//
//    @Override
//    public void addPizzaToOrder(Long userId) {
//        User user = userRepository.findUserById(userId);
//        List<Order> orders = orderRepository.findOrdersForUser(user);
//
//    }
//}
