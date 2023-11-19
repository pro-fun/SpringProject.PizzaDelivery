package by.academypvt.service.impl;

import by.academypvt.contract.serviceApi.OrderApi;

import by.academypvt.domain.entity.*;
import by.academypvt.dto.comment.CommentRequest;
import by.academypvt.dto.enums.DeliveryType;
import by.academypvt.dto.enums.State;
import by.academypvt.dto.order.OrderDeliveryRequest;
import by.academypvt.dto.order.PizzaOrderRequest;
import by.academypvt.dto.order.OrderResponse;
import by.academypvt.dto.order.SauceOrderRequest;
import by.academypvt.dto.pizza.IngredientPizzaRequest;
import by.academypvt.errors.AccountException;
import by.academypvt.errors.FoodEntityException;
import by.academypvt.mapper.OrderMapper;
import by.academypvt.repository.spring.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderApi {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    private final PizzaOrderRepository pizzaOrderRepository;
    private final SauceRepository sauceRepository;
    private final SauceOrderRepository sauceOrderRepository;
    private final IngredientRepository ingredientRepository;
    private final IngredientPizzaRepository ingredientPizzaRepository;
    private final OrderMapper orderMapper;
    private final HttpServletRequest servletRequest;

    @Override
    @Transactional
    public OrderResponse addPizzaToOrder(PizzaOrderRequest pizzaOrderRequest) {
        Pizza pizza = pizzaRepository.findByNameAndSize(pizzaOrderRequest.getName(), pizzaOrderRequest.getSize());
        Long orderId = (Long) servletRequest.getSession().getAttribute("orderId");
        if (orderId == null) {
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        if (pizza == null) {
            throw new FoodEntityException("Данной пиццы нет в базе данных");
        }
        Ingredient ingredient = ingredientRepository.findByName("Без добавок");
        PizzaOrder pizzaOrder = new PizzaOrder(order.get(), pizza, ingredient, pizzaOrderRequest.getCount());
        pizzaOrder.setCost(pizza.getCost().multiply(BigDecimal.valueOf(pizzaOrderRequest.getCount())));
        BigDecimal currentCost = order.get().getCost().add(pizzaOrder.getCost());
        order.get().setCost(currentCost);
        pizzaOrderRepository.save(pizzaOrder);
        return orderMapper.toResponse(orderRepository.save(order.get()));
    }

    @Override
    @Transactional
    public OrderResponse addSauceToOrder(SauceOrderRequest sauceOrderRequest) {
        Sauce sauce = sauceRepository.findByName(sauceOrderRequest.getName());
        Long orderId = (Long) servletRequest.getSession().getAttribute("orderId");
        if (orderId == null) {
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        if (sauce == null) {
            throw new FoodEntityException("Данной пиццы нет в базе данных");
        }
        SauceOrder sauceOrder = new SauceOrder(order.get(), sauce, sauceOrderRequest.getCount());
        sauceOrder.setCost(sauce.getCost().multiply(BigDecimal.valueOf(sauceOrderRequest.getCount())));
        BigDecimal currentCost = order.get().getCost().add(sauceOrder.getCost());
        order.get().setCost(currentCost);
        sauceOrderRepository.save(sauceOrder);
        return orderMapper.toResponse(orderRepository.save(order.get()));
    }

    @Override
    @Transactional
    public OrderResponse addIngredientToPizza(IngredientPizzaRequest ingredientPizzaRequest) {
        Pizza pizza = pizzaRepository.findByNameAndSize(ingredientPizzaRequest.getName(), ingredientPizzaRequest.getSize());
        Long orderId = (Long) servletRequest.getSession().getAttribute("orderId");
        if (orderId == null) {
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        Ingredient ingredient = ingredientRepository.findByName(ingredientPizzaRequest.getIngredient_name());
        if (pizza == null || ingredient == null) {
            throw new FoodEntityException("Данных продуктов нет в базе данных");
        }

        IngredientPizza ingredientPizza = new IngredientPizza(ingredient, pizza, order.get(), ingredientPizzaRequest.getCount());
        ingredientPizza.setCost(ingredient.getCost().multiply(BigDecimal.valueOf(ingredientPizzaRequest.getCount())));
        BigDecimal currentCost = order.get().getCost().add(ingredientPizza.getCost());
        order.get().setCost(currentCost);
        ingredientPizzaRepository.save(ingredientPizza);
        return orderMapper.toResponse(orderRepository.save(order.get()));
    }

    @Override
    @Transactional
    public OrderResponse createOrder() {
        Long orderId = (Long) servletRequest.getSession().getAttribute("orderId");
        Long userId = (Long) servletRequest.getSession().getAttribute("userId");
        if (orderId == null || userId == null) {
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        User user1 = order.get().getUserId();
        order.get().setState(State.COOKING);
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        order.get().setOrderTime(localDateTime);
        orderRepository.save(order.get());

        Order newOrder = new Order();
        newOrder.setUserId(user1);
        newOrder.setState(State.FORMING);
        newOrder.setDeliveryType(DeliveryType.DELIVERY);
        newOrder.setCost(BigDecimal.valueOf(0));
        Long newOrderId = orderRepository.save(newOrder).getId();
        servletRequest.setAttribute("orderId", newOrderId);
        return orderMapper.toResponse(newOrder);
    }

    @Override
    public List<OrderResponse> getUserOrders() {
        Long userId = (Long) servletRequest.getSession().getAttribute("userId");
        if (userId == null) {
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<User> user = userRepository.findById(userId);
        List<Order> orders = orderRepository.findByUserId(user.get());
        return orders.stream().map(orderMapper::toResponse).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public OrderResponse addCommentToOrder(CommentRequest commentRequest) {
        Long orderId = (Long) servletRequest.getSession().getAttribute("orderId");
        if (orderId == null) {
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        order.get().setComment(commentRequest.getComment());
        return orderMapper.toResponse(orderRepository.save(order.get()));
    }

    @Transactional
    @Override
    public OrderResponse toChangeOrderDelivery(OrderDeliveryRequest orderDeliveryRequest) {
        Long orderId = (Long) servletRequest.getSession().getAttribute("orderId");
        if (orderId == null) {
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        order.get().setDeliveryType(orderDeliveryRequest.getDeliveryType());
        return orderMapper.toResponse(orderRepository.save(order.get()));
    }

    @Transactional
    @Override
    public OrderResponse deletePizzaFromOrder(PizzaOrderRequest pizzaOrderRequest) {
        Pizza pizza = pizzaRepository.findByNameAndSize(pizzaOrderRequest.getName(), pizzaOrderRequest.getSize());
        Long orderId = (Long) servletRequest.getSession().getAttribute("orderId");
        if (orderId == null) {
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        if (pizza == null) {
            throw new FoodEntityException("Данной пиццы нет в базе данных");
        }
        PizzaOrder pizzaOrder = pizzaOrderRepository.findByPizzaAndOrder(pizza, order.get());
        if (pizzaOrder.getCount() < pizzaOrderRequest.getCount()) {
            throw new FoodEntityException("В вашем заказе нет такого количества указанных пицц");
        }
        BigDecimal orderCost = order.get().getCost().subtract(pizzaOrder.getCost());
        order.get().setCost(orderCost);
        Long count = pizzaOrder.getCount() - pizzaOrderRequest.getCount();
        if (count == 0) {
            pizzaOrderRepository.delete(pizzaOrder);
            order.get().getPizzas().remove(pizzaOrder);
        }
        return orderMapper.toResponse(orderRepository.save(order.get()));
    }

    @Transactional
    @Override
    public OrderResponse deleteSauceFromOrder(SauceOrderRequest sauceOrderRequest) {
        Sauce sauce = sauceRepository.findByName(sauceOrderRequest.getName());
        Long orderId = (Long) servletRequest.getSession().getAttribute("orderId");
        if (orderId == null) {
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        if (sauce == null) {
            throw new FoodEntityException("Данной пиццы нет в базе данных");
        }
        SauceOrder sauceOrder = sauceOrderRepository.findBySauceAndOrder(sauce, order.get());
        if (sauceOrder.getCount() < sauceOrderRequest.getCount()) {
            throw new FoodEntityException("В вашем заказе нет такого количества указанных пицц");
        }
        BigDecimal orderCost = order.get().getCost().subtract(sauceOrder.getCost());
        order.get().setCost(orderCost);
        Long count = sauceOrder.getCount() - sauceOrderRequest.getCount();
        if (count == 0) {
            sauceOrderRepository.delete(sauceOrder);
            order.get().getPizzas().remove(sauceOrder);
        }
        return orderMapper.toResponse(orderRepository.save(order.get()));
    }

    @Transactional
    @Override
    public OrderResponse deleteIngredientFromPizza(IngredientPizzaRequest ingredientPizzaRequest) {
        Pizza pizza = pizzaRepository.findByNameAndSize(ingredientPizzaRequest.getName(), ingredientPizzaRequest.getSize());
        Long orderId = (Long) servletRequest.getSession().getAttribute("orderId");
        if (orderId == null) {
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        Ingredient ingredient = ingredientRepository.findByName(ingredientPizzaRequest.getIngredient_name());
        if (pizza == null || ingredient == null) {
            throw new FoodEntityException("Данных продуктов нет в базе данных");
        }
        IngredientPizza ingredientPizza = ingredientPizzaRepository.findByIngredientAndPizzaAndOrder(ingredient, pizza, order.get());
        if (ingredientPizza.getCount() < ingredientPizza.getCount()) {
            throw new FoodEntityException("В вашем заказе нет такого количества указанных ингредиентов");
        }
        BigDecimal orderCost = order.get().getCost().subtract(ingredientPizza.getCost());
        order.get().setCost(orderCost);
        Long count = ingredientPizza.getCount() - ingredientPizzaRequest.getCount();
        if (count == 0) {
            ingredientPizzaRepository.delete(ingredientPizza);
            order.get().getPizzas().remove(ingredientPizza);
        }
        return orderMapper.toResponse(orderRepository.save(order.get()));
    }
}
