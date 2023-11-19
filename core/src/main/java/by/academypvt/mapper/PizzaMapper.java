package by.academypvt.mapper;

import by.academypvt.domain.entity.Pizza;
import by.academypvt.dto.pizza.PizzaRequest;
import by.academypvt.dto.pizza.PizzaResponse;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component

public class PizzaMapper {
    IngredientPizzaMapper ingredientPizzaMapper = new IngredientPizzaMapper();

    public PizzaResponse toResponse(Pizza pizza) {
        PizzaResponse pizzaResponse = new PizzaResponse();
        pizzaResponse.setId(pizza.getId());
        pizzaResponse.setName(pizza.getName());
        pizzaResponse.setSize(pizza.getSize());
        pizzaResponse.setCost(pizza.getCost());
        pizzaResponse.setIngredients(pizza.getIngredients().stream().map(ingredientPizzaMapper::toResponse).collect(Collectors.toList()));
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
