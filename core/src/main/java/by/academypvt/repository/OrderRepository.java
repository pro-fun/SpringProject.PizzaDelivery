package by.academypvt.repository;

import by.academypvt.domain.entity.Order;
import by.academypvt.domain.entity.User;
import by.academypvt.dto.order.OrderRequest;
import by.academypvt.dto.order.OrderResponse;

import java.util.List;

public interface OrderRepository {
    Order findOrderById(Long id);
    void addOrder(Order order);
    void deleteOrderById(Long id);
    List<Order> updateOrders();
    List<Order> findOrdersForUser(User user);
}
