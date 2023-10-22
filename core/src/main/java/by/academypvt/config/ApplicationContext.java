package by.academypvt.config;

import by.academypvt.mapper.OrderMapper;
import by.academypvt.mapper.UserMapper;
import by.academypvt.repository.*;
import by.academypvt.repository.impl.*;
import by.academypvt.service.*;
import by.academypvt.service.impl.*;

public class ApplicationContext {
    private static ApplicationContext applicationContext;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    private final SauceRepository sauceRepository;
    private final IngredientRepository ingredientRepository;
    private final UserService userService;
    private final AdminService adminService;
    private final OrderService orderService;

    private final UserMapper userMapper;
    private final OrderMapper orderMapper;


    private ApplicationContext() {
        userRepository = new UserRepositoryHibernate();
        orderRepository=new OrderRepositoryHibernate();
        pizzaRepository=new PizzaRepositoryHibernate();
        sauceRepository=new SauceRepositoryHibernate();
        ingredientRepository=new IngredientRepositoryHibernate();
        orderMapper = new OrderMapper();
        userMapper=new UserMapper();
        userService = new UserServiceJpa(userRepository,userMapper);
        adminService = new AdminServiceJpa(userRepository,userMapper);
        orderService = new OrderServiceJpa(orderRepository,orderMapper);
    }

    public static ApplicationContext getInstance() {
        if (applicationContext == null) {
            applicationContext = new ApplicationContext();
        }
        return applicationContext;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public UserService getUserService() {
        return userService;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }


    public PizzaRepository getPizzaRepository() {
        return pizzaRepository;
    }

    public SauceRepository getSauceRepository() {
        return sauceRepository;
    }

    public IngredientRepository getIngredientRepository() {
        return ingredientRepository;
    }


    public OrderService getOrderService() {
        return orderService;
    }


    public OrderMapper getOrderMapper() {
        return orderMapper;
    }
}
