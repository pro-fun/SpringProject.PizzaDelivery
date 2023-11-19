package by.academypvt.mapper;

import by.academypvt.domain.entity.IngredientPizza;
import by.academypvt.domain.entity.SauceOrder;
import by.academypvt.dto.order.SauceOrderResponse;
import by.academypvt.dto.pizza.IngredientPizzaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientPizzaMapper {
    IngredientMapper ingredientMapper = new IngredientMapperImpl();
    public IngredientPizzaResponse toResponse(IngredientPizza ingredientPizza) {
        IngredientPizzaResponse ingredientPizzaResponse = new IngredientPizzaResponse();
        ingredientPizzaResponse.setIngredient(ingredientMapper.toResponse(ingredientPizza.getIngredient()));
        ingredientPizzaResponse.setCount(ingredientPizza.getCount());
        return ingredientPizzaResponse;
    }
}
