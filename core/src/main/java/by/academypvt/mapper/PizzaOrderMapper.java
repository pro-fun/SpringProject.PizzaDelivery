package by.academypvt.mapper;

import by.academypvt.domain.entity.PizzaOrder;
import by.academypvt.dto.order.PizzaOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PizzaOrderMapper {
    PizzaMapper pizzaMapper = new PizzaMapper();
    IngredientMapper ingredientMapper = new IngredientMapperImpl();
    public PizzaOrderResponse toResponse(PizzaOrder pizzaOrder) {
        PizzaOrderResponse pizzaOrderResponse = new PizzaOrderResponse();
        pizzaOrderResponse.setPizza(pizzaMapper.toResponse(pizzaOrder.getPizza()));
        pizzaOrderResponse.setCount(pizzaOrder.getCount());
        pizzaOrderResponse.setIngredient(ingredientMapper.toResponse(pizzaOrder.getIngredient()));
        return pizzaOrderResponse;
    }
}
