package by.academypvt.service;

import by.academypvt.domain.entity.Pizza;

import java.util.List;

public interface PizzaService {
    Pizza findPizzaById(Long id);
    void addPizza(Pizza pizza);
    void deletePizzaById(Long id);
    List<Pizza> updatePizzas();
}
