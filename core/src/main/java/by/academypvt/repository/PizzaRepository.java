package by.academypvt.repository;

import by.academypvt.domain.entity.Pizza;

import java.util.List;

public interface PizzaRepository {
    Pizza findPizzaById(Long id);
    void addPizza(Pizza pizza);
    void deletePizzaById(Long id);
    List<Pizza> updatePizzas();
}
