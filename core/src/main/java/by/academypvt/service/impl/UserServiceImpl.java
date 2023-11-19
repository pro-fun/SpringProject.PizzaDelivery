package by.academypvt.service.impl;

import by.academypvt.contract.serviceApi.UserApi;
import by.academypvt.domain.entity.Order;
import by.academypvt.domain.entity.User;
import by.academypvt.dto.enums.DeliveryType;
import by.academypvt.dto.enums.State;
import by.academypvt.dto.user.UserCreateRequest;
import by.academypvt.dto.user.UserLoginRequest;
import by.academypvt.dto.user.UserResponse;
import by.academypvt.errors.AccountException;
import by.academypvt.mapper.OrderMapper;
import by.academypvt.mapper.PizzaMapper;
import by.academypvt.mapper.UserMapper;
import by.academypvt.repository.spring.OrderRepository;
import by.academypvt.repository.spring.PizzaRepository;
import by.academypvt.repository.spring.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserApi {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    private final UserMapper userMapper;
    private final OrderMapper orderMapper;
    private final PizzaMapper pizzaMapper;
    private final PasswordEncoder passwordEncoder;
    private final HttpServletRequest servletRequest;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByLogin(username);
        return user;
    }

    @Transactional
    @Override
    public UserResponse addUser(@NotNull UserCreateRequest userCreateRequest) {
        if(userRepository.findByLogin(userCreateRequest.getLogin()) != null) {
            throw new AccountException("Данный логин уже используется");
        }
        var user = userMapper.toEntityCreate(userCreateRequest);
        String encodingString = passwordEncoder.encode(userCreateRequest.getPassword());
        user.setPassword(encodingString);
        user.setRole("USER");
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public UserResponse login(UserLoginRequest userLoginRequest) throws ServletException {
        servletRequest.login(userLoginRequest.getLogin(), userLoginRequest.getPassword());
        User user = userRepository.findByLogin(userLoginRequest.getLogin());
        Long userId = user.getId();
        servletRequest.getSession().setAttribute("userId", userId);
        List<Order> orders = orderRepository.findByUserId(user);
        Optional<Order> order = orders.stream().filter(order1 -> order1.getState().equals(State.FORMING)).findFirst();
        if (order.isEmpty()){
            Order order1 = new Order();
            order1.setUserId(user);
            order1.setState(State.FORMING);
            order1.setDeliveryType(DeliveryType.DELIVERY);
            order1.setCost(BigDecimal.valueOf(0));
            Long orderId = orderRepository.save(order1).getId();
            servletRequest.setAttribute("orderId", orderId);
        }else {
            Long orderId = order.get().getId();
        servletRequest.getSession().setAttribute("orderId", orderId);
        }
        return userMapper.toResponse(user);
    }
}
