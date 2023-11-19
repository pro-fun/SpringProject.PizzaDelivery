package by.academypvt.service.impl;

import by.academypvt.contract.serviceApi.AdminApi;
import by.academypvt.dto.user.UserResponse;
import by.academypvt.errors.UserIdException;
import by.academypvt.mapper.OrderMapper;
import by.academypvt.mapper.UserMapper;
import by.academypvt.repository.spring.OrderRepository;
import by.academypvt.repository.spring.PizzaRepository;
import by.academypvt.repository.spring.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminApi {
    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> allUsers() {
        return userRepository.findAll().stream().map(userMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long id) {
        Optional<UserResponse> userResponse = Optional.of(userMapper.toResponse(userRepository.findById(id).orElseThrow(() -> new UserIdException("Пользователя с данным Id нет в базе данных"))));
        return userResponse.get();
    }
    @Transactional
    @Override
    public void deleteUser(Long id) { userRepository.deleteById(id); }
}
