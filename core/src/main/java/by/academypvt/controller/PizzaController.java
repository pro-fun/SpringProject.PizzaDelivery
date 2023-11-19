package by.academypvt.controller;

import by.academypvt.contract.restApi.PizzaRestApi;
import by.academypvt.contract.serviceApi.PizzaApi;
import by.academypvt.dto.pizza.PizzaRequest;
import by.academypvt.dto.pizza.PizzaResponse;
import by.academypvt.dto.pizza.PizzaSizeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PizzaController implements PizzaRestApi {
    private final PizzaApi pizzaService;

    @Override
    public List<PizzaResponse> allPizzas() {
        return pizzaService.allPizzas();
    }

    @Override
    public PizzaResponse addPizza(PizzaRequest pizzaRequest) {
        return pizzaService.addPizza(pizzaRequest);
    }

    @Override
    public void deletePizza(Long id) {
        pizzaService.deletePizza(id);
    }

    @Override
    public List<PizzaResponse> getPizzasBySize(PizzaSizeRequest pizzaSizeRequest) {
        return pizzaService.getPizzasBySize(pizzaSizeRequest);
    }
}
