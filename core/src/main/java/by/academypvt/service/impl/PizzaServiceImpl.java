package by.academypvt.service.impl;

import by.academypvt.contract.serviceApi.PizzaApi;
import by.academypvt.domain.entity.Pizza;
import by.academypvt.dto.pizza.PizzaRequest;
import by.academypvt.dto.pizza.PizzaResponse;
import by.academypvt.dto.pizza.PizzaSizeRequest;
import by.academypvt.errors.FoodEntityException;
import by.academypvt.mapper.PizzaMapper;
import by.academypvt.repository.spring.PizzaRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public PizzaResponse addPizza(@NotNull PizzaRequest pizzaRequest) {
        if (pizzaRepository.findByNameAndSize(pizzaRequest.getName(), pizzaRequest.getSize()) != null) {
            throw new FoodEntityException("Данная пицца уже есть в базе данных");
        }
        Pizza pizza = pizzaMapper.toEntity(pizzaRequest);
        return pizzaMapper.toResponse(pizzaRepository.save(pizza));
    }

    @Transactional
    @Override
    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }

    @Override
    public List<PizzaResponse> getPizzasBySize(PizzaSizeRequest pizzaSizeRequest) {
        List<Pizza> pizzas = pizzaRepository.findAll();
        List<Pizza> filteredPizzas = pizzas.stream().filter(pizza -> pizza.getSize().equals(pizzaSizeRequest.getSize())).toList();
        if(filteredPizzas.isEmpty()){
            throw new FoodEntityException("Пицц с таким размером нет в базе данных");
        }
        return filteredPizzas.stream().map(pizzaMapper::toResponse).collect(Collectors.toList());
    }
}

