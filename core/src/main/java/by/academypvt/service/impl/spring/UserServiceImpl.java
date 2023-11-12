package by.academypvt.service.impl.spring;

import by.academypvt.contract.UserApi;
import by.academypvt.dto.pizza.PizzaResponse;
import by.academypvt.mapper.OrderMapper;
import by.academypvt.mapper.PizzaMapper;
import by.academypvt.repository.spring.PizzaRepository;
import by.academypvt.repository.spring.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserApi {
    private final UserRepository userRepository;
    private final PizzaRepository pizzaRepository;
    private final OrderMapper orderMapper;
    private final PizzaMapper pizzaMapper;

    @Override
    public List<PizzaResponse> allPizzas() {
        return pizzaRepository.findAll().stream().map(pizzaMapper::toResponse).collect(Collectors.toList());
    }
}
