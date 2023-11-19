package by.academypvt.service.impl;

import by.academypvt.contract.serviceApi.OrderApi;

import by.academypvt.domain.entity.*;
import by.academypvt.dto.ingredient.IngredientRequest;
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
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderApi {
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
        if (orderId==null){
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        if (pizza==null){
            throw new FoodEntityException("Данной пиццы нет в базе данных");
        }
        Ingredient ingredient = ingredientRepository.findByName("Без добавок");
        PizzaOrder pizzaOrder = new PizzaOrder(order.get(), pizza,ingredient, pizzaOrderRequest.getCount());
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
        if (orderId==null){
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        if (sauce==null){
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
    public OrderResponse addIngredientToPizza(IngredientPizzaRequest ingredientPizzaRequest) {
        Pizza pizza = pizzaRepository.findByNameAndSize(ingredientPizzaRequest.getName(), ingredientPizzaRequest.getSize());
        Long orderId = (Long) servletRequest.getSession().getAttribute("orderId");
        if (orderId==null){
            throw new AccountException("Пройдите авторизацию");
        }
        Optional<Order> order = orderRepository.findById(orderId);
        Ingredient ingredient = ingredientRepository.findByName(ingredientPizzaRequest.getIngredient_name());
        if (pizza==null || ingredient==null){
            throw new FoodEntityException("Данных продуктов нет в базе данных");
        }

        IngredientPizza ingredientPizza = new IngredientPizza(ingredient,pizza,order.get(),ingredientPizzaRequest.getCount());
        ingredientPizza.setCost(ingredient.getCost().multiply(BigDecimal.valueOf(ingredientPizzaRequest.getCount())));
        BigDecimal currentCost = order.get().getCost().add(ingredientPizza.getCost());
        order.get().setCost(currentCost);
        ingredientPizzaRepository.save(ingredientPizza);
        return orderMapper.toResponse(orderRepository.save(order.get()));
    }
}
