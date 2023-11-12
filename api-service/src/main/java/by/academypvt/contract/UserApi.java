package by.academypvt.contract;

import by.academypvt.dto.pizza.PizzaResponse;

import java.util.List;

public interface UserApi {
    List<PizzaResponse> allPizzas();
}
