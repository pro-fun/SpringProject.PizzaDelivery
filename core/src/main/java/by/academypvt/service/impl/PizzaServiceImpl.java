package by.academypvt.service.impl;

import by.academypvt.contract.serviceApi.PizzaApi;
import by.academypvt.domain.entity.Pizza;
import by.academypvt.dto.pizza.PizzaRequest;
import by.academypvt.dto.pizza.PizzaResponse;
import by.academypvt.errors.FoodEntityException;
import by.academypvt.mapper.PizzaMapper;
import by.academypvt.repository.spring.PizzaRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaApi {
    private final PizzaRepository pizzaRepository;
    private final PizzaMapper pizzaMapper;

    @Override
    public List<PizzaResponse> allPizzas() {
        return pizzaRepository.findAll().stream().map(pizzaMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public PizzaResponse addPizza(@NotNull PizzaRequest pizzaRequest) {
        if(pizzaRepository.findByNameAndSize(pizzaRequest.getName(), pizzaRequest.getSize()) != null){
            throw new FoodEntityException("Данная пицца уже есть в базе данных");
        }
        Pizza pizza = pizzaMapper.toEntity(pizzaRequest);
        return pizzaMapper.toResponse(pizzaRepository.save(pizza));
    }
}

