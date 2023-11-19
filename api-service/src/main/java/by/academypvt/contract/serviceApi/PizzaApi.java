package by.academypvt.contract.serviceApi;

import by.academypvt.dto.pizza.PizzaRequest;
import by.academypvt.dto.pizza.PizzaResponse;
import by.academypvt.dto.pizza.PizzaSizeRequest;

import java.util.List;

public interface PizzaApi {
    List<PizzaResponse> allPizzas();
    PizzaResponse addPizza(PizzaRequest pizzaRequest);
    void deletePizza(Long id);
    List<PizzaResponse> getPizzasBySize(PizzaSizeRequest pizzaSizeRequest);
}
