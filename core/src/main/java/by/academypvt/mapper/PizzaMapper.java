package by.academypvt.mapper;

import by.academypvt.domain.entity.Pizza;
import by.academypvt.dto.pizza.PizzaRequest;
import by.academypvt.dto.pizza.PizzaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component

public class PizzaMapper {

    public PizzaResponse toResponse(Pizza pizza) {
        PizzaResponse pizzaResponse = new PizzaResponse();
        pizzaResponse.setId(pizza.getId());
        pizzaResponse.setName(pizza.getName());
        pizzaResponse.setSize(pizza.getSize());
        pizzaResponse.setCost(pizza.getCost());
        return pizzaResponse;
    }
    public Pizza toEntity(PizzaRequest pizzaRequest) {
        Pizza pizza = new Pizza();
        pizza.setName(pizzaRequest.getName());
        pizza.setSize(pizzaRequest.getSize());
        pizza.setCost(pizzaRequest.getCost());
        return pizza;
    }
}
