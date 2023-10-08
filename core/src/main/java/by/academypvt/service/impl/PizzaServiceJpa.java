package by.academypvt.service.impl;

import by.academypvt.domain.entity.Pizza;
import by.academypvt.repository.PizzaRepository;
import by.academypvt.service.PizzaService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PizzaServiceJpa implements PizzaService {
    private final PizzaRepository pizzaRepository;

    @Override
    public Pizza findPizzaById(Long id) {
        return pizzaRepository.findPizzaById(id);
    }

    @Override
    public void addPizza(Pizza pizza) {
        pizzaRepository.addPizza(pizza);
    }

    @Override
    public void deletePizzaById(Long id) {
        pizzaRepository.deletePizzaById(id);
    }

    @Override
    public List<Pizza> updatePizzas() {
        return pizzaRepository.updatePizzas();
    }
}
