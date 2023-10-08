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
    private final PositionRepository positionRepository;
    private final PizzaRepository pizzaRepository;
    private final SauceRepository sauceRepository;
    private final IngredientRepository ingredientRepository;
    private final UserService userService;
    private final AdminService adminService;
    private final PositionService positionService;
    private final PizzaService pizzaService;
    private final SauceService sauceService;
    private final OrderService orderService;
    private final IngredientService ingredientService;
    private final UserMapper userMapper;
    private final OrderMapper orderMapper;


    private ApplicationContext() {
        userRepository = new UserRepositoryHibernate();
        orderRepository=new OrderRepositoryHibernate();
        positionRepository=new PositionRepositoryHibernate();
        pizzaRepository=new PizzaRepositoryHibernate();
        sauceRepository=new SauceRepositoryHibernate();
        ingredientRepository=new IngredientRepositoryHibernate();
        orderMapper = new OrderMapper();
        userMapper=new UserMapper();
        userService = new UserServiceJpa(userRepository,userMapper);
        adminService = new AdminServiceJpa(userRepository,userMapper);
        orderService = new OrderServiceJpa(orderRepository,orderMapper);
        positionService = new PositionServiceJpa(positionRepository);
        pizzaService = new PizzaServiceJpa(pizzaRepository);
        sauceService = new SauceServiceJpa(sauceRepository);
        ingredientService = new IngredientServiceJpa(ingredientRepository);
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

    public PositionRepository getPositionRepository() {
        return positionRepository;
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

    public PositionService getPositionService() {
        return positionService;
    }

    public PizzaService getPizzaService() {
        return pizzaService;
    }

    public SauceService getSauceService() {
        return sauceService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public IngredientService getIngredientService() {
        return ingredientService;
    }

    public OrderMapper getOrderMapper() {
        return orderMapper;
    }
}
