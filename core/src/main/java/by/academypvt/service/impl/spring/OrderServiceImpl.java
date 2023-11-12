package by.academypvt.service.impl.spring;

import by.academypvt.contract.OrderApi;

import by.academypvt.domain.entity.*;
import by.academypvt.dto.order.OrderPizzaRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.dto.order.OrderSauceRequest;
import by.academypvt.mapper.OrderMapper;
import by.academypvt.repository.spring.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderApi {
    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    private final PizzaOrderRepository pizzaOrderRepository;
    private final SauceRepository sauceRepository;
    private final SauceOrderRepository sauceOrderRepository;
    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderResponse addPizzaToOrder(OrderPizzaRequest orderPizzaRequest) {
        Pizza pizza = pizzaRepository.findByNameAndSize(orderPizzaRequest.getName(), orderPizzaRequest.getSize());
        var order = orderRepository.findById(orderPizzaRequest.getOrderId());
        PizzaOrder pizzaOrder = new PizzaOrder(order.get(), pizza, orderPizzaRequest.getCount());
        pizzaOrder.setCost(pizza.getCost() * orderPizzaRequest.getCount());
        Float currentCost = order.get().getCost() + pizza.getCost() * orderPizzaRequest.getCount();
        order.get().setCost(currentCost);
        pizzaOrderRepository.save(pizzaOrder);
        return orderMapper.toResponse(orderRepository.save(order.get()));
    }

    @Override
    @Transactional
    public OrderResponse addSauceToOrder(OrderSauceRequest orderSauceRequest) {
        var sauce = sauceRepository.findByName(orderSauceRequest.getName());
        var order = orderRepository.findById(orderSauceRequest.getOrderId());
        SauceOrder sauceOrder = new SauceOrder(order.get(), sauce, orderSauceRequest.getCount());
        sauceOrder.setCost(sauce.getCost() * orderSauceRequest.getCount());
        Float currentCost = order.get().getCost() + sauce.getCost() * orderSauceRequest.getCount();
        order.get().setCost(currentCost);
        sauceOrderRepository.save(sauceOrder);
        return orderMapper.toResponse(orderRepository.save(order.get()));
    }
}
